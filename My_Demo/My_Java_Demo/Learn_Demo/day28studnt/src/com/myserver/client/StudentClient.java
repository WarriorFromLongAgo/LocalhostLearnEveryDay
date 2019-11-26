package com.myserver.client;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class StudentClient {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PrintWriter printWriter = null;
        String studentUserName = null;
        String studentName = null;
        String studentAge = null;
        String studentClassName = null;

        boolean systemExit = false;
        while (!systemExit) {


            System.out.println(" 欢迎来到学生管理系统 ");
            System.out.println(" 1，添加学生 ");
            System.out.println(" 2，查询学生（通过学生账号） ");
            System.out.println(" 3，显示所有学生 ");
            System.out.println(" 4，修改学生（通过学生账号） ");
            System.out.println(" 5，删除学生（通过学生账号） ");
            System.out.println(" 6，暂无功能 ");
            System.out.println(" 7，退出系统 ");
            System.out.println(" 请进行您的选择 ");

            //  这里会抛异常，如果输入字母的话
            int i = scanner.nextInt();
            scanner.nextLine();
            switch (i) {
                case 1:
                    try {
                        Socket client = new Socket(InetAddress.getLocalHost().getHostName(), 8080);
                        //  userName::Name::Age:ClassName
                        //  用户账号::姓名::年龄::班级
                        boolean strContainNotNumber = false;
                        while (true) {
                            System.out.println(" 开始录入学生信息 ");
                            System.out.println(" 请输入学生的用户账号（可以使用字母、数字、字符，字母不区分大小写） ");
                            studentUserName = scanner.nextLine();
                            System.out.println(" 请输入学生的姓名 ");
                            studentName = scanner.nextLine();

                            //  查看输入的string是否含有 非数字
                            while (true) {
                                System.out.println(" 请输入学生的年龄（只支持数字） ");
                                studentAge = scanner.nextLine();
                                for (int j = 0; j < studentAge.length(); j++) {
                                    if (studentAge.charAt(j) < '0' || studentAge.charAt(j) > '9') {
                                        //  含有非数字标志，置起
                                        strContainNotNumber = true;
                                        break;
                                    } else {
                                        strContainNotNumber = false;
                                    }
                                }
                                //  如果含有非数字，则必须重新开始输入
                                if (strContainNotNumber) {
                                    System.out.println(" 年龄包含特殊字符或者字母，非法输入 ");
                                    System.out.println(" 请重新开始输入 ");
                                    continue;
                                }
                                break;
                            }

                            System.out.println(" 请输入学生的班级 ");
                            studentClassName = scanner.nextLine();

                            String outToServer = studentUserName + "::" + studentName + "::" + studentAge + "::" + studentClassName;
                            System.out.println(outToServer);
                            printWriter = new PrintWriter(client.getOutputStream(), true);
                            printWriter.println(outToServer);
//                            printWriter.close();

                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                            System.out.println("------------");
                            boolean flagAlreadyExists = false;

                            String inToServer = "";
                            String readServerInfo = "";
                            while ((inToServer = bufferedReader.readLine()) != null) {
                                readServerInfo = readServerInfo + inToServer;
                            }

                            if ("已经存在该用户".equals(readServerInfo)) {
                                flagAlreadyExists = true;
                            }
                            if (flagAlreadyExists) {
                                System.out.println("该用户已经存在，请重新输入");
                                continue;
                            }
                            System.out.println(readServerInfo);
                            System.out.println("------------");

                            client.close();
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        Socket client = new Socket(InetAddress.getLocalHost().getHostName(), 8081);
                        System.out.println(" 开始查找学生信息（请输入被查找学生的用户账号） ");
                        String strUserName = scanner.nextLine();
                        System.out.println(strUserName);

                        printWriter = new PrintWriter(client.getOutputStream(), true);
                        printWriter.println(strUserName);

                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

                        String inToServer = bufferedReader.readLine();
                        System.out.println(inToServer);
                        System.out.println("------------");

                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        Socket client = new Socket(InetAddress.getLocalHost().getHostName(), 8082);
                        System.out.println(" 开始显示所有的学生信息 ");
                        printWriter = new PrintWriter(client.getOutputStream(), true);
                        printWriter.println();

                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        String inToServer = null;
                        while ((inToServer = bufferedReader.readLine()) != null) {
                            System.out.println(inToServer);
                            if (inToServer == null) {
                                continue;
                            }
                        }
                        System.out.println("------------");

//                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        Socket client = new Socket(InetAddress.getLocalHost().getHostName(), 8083);
                        System.out.println(" 开始查找学生信息 ");
                        System.out.println(" 请输入被修改学生的用户账号 ");
                        String strUserName = scanner.nextLine();
                        System.out.println(" 请输入修改后的学生的姓名 ");
                        String strName = scanner.nextLine();
                        System.out.println(" 请输入修改后的学生的年龄 ");
                        String strAge = scanner.nextLine();
                        System.out.println(" 请输入修改后的学生的班级 ");
                        String strClassName = scanner.nextLine();

                        String outToServer = strUserName + "::" + strName + "::" + strAge + "::" + strClassName;
                        System.out.println(outToServer);
                        printWriter = new PrintWriter(client.getOutputStream(), true);
                        printWriter.println(outToServer);
//                        printWriter.close();

                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

                        String inToServer = bufferedReader.readLine();
                        System.out.println(inToServer);
                        System.out.println("------------");

//                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        Socket client = new Socket(InetAddress.getLocalHost().getHostName(), 10086);
                        System.out.println(" 开始删除学生信息 ");
                        System.out.println(" 请输入被删除学生的用户账号 ");
                        String strUserName = scanner.nextLine();
                        System.out.println(strUserName);

                        printWriter = new PrintWriter(client.getOutputStream(), true);
                        printWriter.println(strUserName);

                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

                        String inToServer = bufferedReader.readLine();
                        System.out.println(inToServer);
                        System.out.println("------------");

//                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("无此功能，请重新输入");
                    break;
                case 7:
                    systemExit = true;
                    System.out.println(" 系统退出，感谢您的使用 ");
                    break;
                default:
                    System.out.println("输入的字符有误，无此功能，请重新输入");
                    break;
            }
        }
    }
}
