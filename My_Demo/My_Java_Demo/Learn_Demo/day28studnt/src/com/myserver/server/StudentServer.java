package com.myserver.server;

import com.myserver.mysqldeal.MysqlBean;
import com.myserver.mysqldeal.MysqlDeal;
import com.myserver.studentbeans.StudentBeans;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.*;

public class StudentServer {
    public static void main(String[] args) {
        new MysqlDeal().testMysql();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 10,
                10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
//
//        //  8080端口  增加任务
        Future<?> submitAddTask = threadPoolExecutor.submit(new AddTask());
//        //  8081端口  查到单个学生信息
        Future<?> submitFindTask = threadPoolExecutor.submit(new FindTask());
//        //  8082端口  显示所有的学生信息的任务
        Future<?> submitDisplayAllTask = threadPoolExecutor.submit(new displayAllTask());
//        //  8083端口  修改学生的任务
        Future<?> submitUpdataTask = threadPoolExecutor.submit(new UpdataTask());
//        //  8084端口  删除学生的任务
        Future<?> submitDeleteTask = threadPoolExecutor.submit(new DeleteTask());
    }
}

class AddTask implements Runnable {

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(8080);

            while (true) {
                Socket accept = server.accept();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                String readClientAddTask = bufferedReader.readLine();
//                readClientAddTask = IODeal.ioRead(server, accept, bufferedReader, readClientAddTask);
                System.out.println("接收到的信息为 = " + readClientAddTask);

                //  userName::Name::Age:ClassName
                //  用户账号::姓名::年龄::班级
                String[] split = readClientAddTask.split("::");
                String studentUserName = split[0];
                String studentName = split[1];
                Integer studentAge = Integer.parseInt(split[2]);
                String studentClassName = split[3];

                //  查询数据库中是否存在该用户账号
                MysqlBean mysqlBeanAddTask = new MysqlDeal();
                boolean selectAnyColum = mysqlBeanAddTask.selectAnyColum("studentUserName", studentUserName);
                System.out.println("selectAnyColum = " + selectAnyColum);

                //  启动printWriter服务


                String outClient = null;
                boolean insertFlag = false;
                if (selectAnyColum) {
                    outClient = "已经存在该用户";
                    System.out.println(" 已经存在该用户 ");
                } else {
                    String strUUID = Base64.getEncoder().encodeToString(studentUserName.getBytes());
//                    String strUUID = UUID.randomUUID().toString().replace("-", "");
                    insertFlag = mysqlBeanAddTask.insertMysql(new StudentBeans(strUUID, studentUserName, studentName, studentAge, studentClassName));
                    System.out.println("insertFlag = " + insertFlag);
                    if (insertFlag && !selectAnyColum) {
                        outClient = "增加成功,学生账号、姓名、年龄、班级为" + studentUserName +
                                "," + studentName + "," + studentAge + "," + studentClassName;
                    }
                    if (!selectAnyColum && !insertFlag) {
                        outClient = "未知因素，添加失败，请联系 系统管理";
                        System.out.println("数据库中不存在该用户的UserName，但是仍然无法插入");
                    }
                }

                System.out.println("outClient = " + outClient);
                System.out.println("accept = " + accept);
                PrintWriter printWriter = new PrintWriter(accept.getOutputStream(), true);
                printWriter.println(outClient);
                printWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(" 服务器启动异常 ");
        }
    }
}

@SuppressWarnings("all")
class FindTask implements Runnable {

    @Override
    public void run() {
        try {
            ServerSocket client = new ServerSocket(8081);
            while (true) {

                Socket accept = client.accept();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));

                String readClientAddTask = bufferedReader.readLine();

                //  输入的是 用户的用户账号
                System.out.println("接收到的信息为 = " + readClientAddTask);
                //  userName
                //  用户账号

                //  查询数据库中是否存在该用户账号
                MysqlBean mysqlBeanAddTask = new MysqlDeal();
                boolean selectAnyColum = mysqlBeanAddTask.selectAnyColum("studentUserName", readClientAddTask);

                //  启动printWriter服务
                PrintWriter printWriter = new PrintWriter(accept.getOutputStream(), true);

                //  输出的内容
                String outClient = null;
                //  如果查找到了，则进行查找，则进行输出该行的 内容
                if (selectAnyColum) {
                    Map<String, StudentBeans> strStudentBeansMap = mysqlBeanAddTask.selectOneRow(readClientAddTask);

                    StudentBeans studentBeans = strStudentBeansMap.get(readClientAddTask);

                    outClient = "学生姓名" + studentBeans.getStudentName() + "学生班级" + studentBeans.getStudentClassName()
                            + "学生账号" + studentBeans.getStudentUserName();
                } else {
                    outClient = "该用户账号不存在，请重新输入用户账号";
                }

                printWriter.println(outClient);
                printWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(" 服务器启动异常 ");
        }
    }
}

class displayAllTask implements Runnable {

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(8082);

            while (true) {
                Socket accept = server.accept();
                String readClientAddTask = null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                //  输入的是 用户的用户账号
                readClientAddTask = bufferedReader.readLine();
                System.out.println("接收到的信息为 = " + readClientAddTask);

                MysqlDeal mysqlDeal = new MysqlDeal();
                StringBuilder stringBuilder = new StringBuilder();

                Map<String, StudentBeans> strStudentBeansMap = mysqlDeal.displayAllData();
                if (strStudentBeansMap.isEmpty()) {
                    stringBuilder.append("没有添加数据，请添加后再查询");
                } else {
                    for (Map.Entry<String, StudentBeans> strStudentBeansEntry : strStudentBeansMap.entrySet()) {
                        stringBuilder.append(strStudentBeansEntry.getValue().getStudentUserName()).append(",");
                        stringBuilder.append(strStudentBeansEntry.getValue().getStudentName()).append(",");
                        stringBuilder.append(strStudentBeansEntry.getValue().getStudentAge()).append(",");
                        stringBuilder.append(strStudentBeansEntry.getValue().getStudentClassName()).append(",");
                        stringBuilder.append(System.lineSeparator());
                    }
                }

                System.out.println(stringBuilder.toString());
                PrintWriter printWriter = new PrintWriter(accept.getOutputStream(), true);
                printWriter.println(stringBuilder.toString());
                printWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

@SuppressWarnings("all")
class UpdataTask implements Runnable {

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(8083);
            while (true) {
                Socket accept = server.accept();
                String readClientAddTask = null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));

                //  输入的是 用户的用户账号
                readClientAddTask = bufferedReader.readLine();
                System.out.println("接收到的信息为 = " + readClientAddTask);

                //  userName::Name::Age:ClassName
                //  用户账号::姓名::年龄::班级
                String[] split = readClientAddTask.split("::");
                String studentUserName = split[0];
                String studentName = split[1];
                Integer studentAge = Integer.parseInt(split[2]);
                String studentClassName = split[3];

                //  查询数据库中是否存在该用户账号
                MysqlBean mysqlBeanAddTask = new MysqlDeal();
                boolean selectAnyColum = mysqlBeanAddTask.selectAnyColum("studentUserName", studentUserName);

                //  启动printWriter服务
                PrintWriter printWriter = new PrintWriter(accept.getOutputStream(), true);

                //  输出的内容
                String outClient = null;
                //  如果查找到了，则进行直接修改
                if (selectAnyColum) {
                    boolean updataFlag = mysqlBeanAddTask.updataMysql(new StudentBeans(studentUserName, studentName,
                            studentAge, studentClassName));
                    if (updataFlag) {
                        outClient = "修改成功";
                    } else {
                        outClient = "修改失败";
                        System.out.println("该用户存在，但是仍然修改失败");
                    }
                } else {
                    outClient = "该用户账号不存在，请重新输入用户账号";
                }

                printWriter.println(outClient);
                printWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(" 服务器启动异常 ");
        }
    }
}

class DeleteTask implements Runnable {

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(10086);
            while (true) {
                Socket accept = server.accept();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                String readClientAddTask = bufferedReader.readLine();
                //  输入的是 用户的用户账号
                System.out.println("接收到的信息为 = " + readClientAddTask);

                //  userName
                //  用户账号

                //  查询数据库中是否存在该用户账号
                MysqlBean mysqlBeanAddTask = new MysqlDeal();
                boolean selectAnyColum = mysqlBeanAddTask.selectAnyColum("studentUserName", readClientAddTask);

                //  输出的内容
                String outClient = null;
                //  如果查找到了，则进行直接删除
                if (selectAnyColum) {
                    boolean deleteFlag = mysqlBeanAddTask.deleteMysql(readClientAddTask);
                    if (deleteFlag) {
                        outClient = "删除成功";
                    } else {
                        outClient = "删除失败";
                        System.out.println("该用户存在，但是仍然输出失败");
                    }
                } else {
                    outClient = "该用户账号不存在，请重新输入用户账号";
                }

                //  启动printWriter服务
                PrintWriter printWriter = new PrintWriter(accept.getOutputStream(), true);
                printWriter.println(outClient);

            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(" 服务器启动异常 ");
        }
    }
}