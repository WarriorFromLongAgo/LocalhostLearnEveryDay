package com.day22_IO_SQL.day22homework.iodeal;

import com.day22_IO_SQL.day22homework.Student;

import java.io.*;
import java.util.Map;

public class writerIO {
    public void writerToFile(Map<Integer, Student> intStudentMap) {
        //  遍历发过来的20个数据
        for (Map.Entry<Integer, Student> intStudentEntry : intStudentMap.entrySet()) {
            //  只对map的value进行处理，传参到outPutStreamFile方法中
            outPutStreamFile(intStudentEntry.getValue());
        }
    }

    private void outPutStreamFile(Student student) {
        //  用StringBuilder 进行字符串的拼接
        StringBuilder stringBuilder = new StringBuilder();
        try (
                //  输出流 和 缓冲输出流的创建
                OutputStream outputStream = new FileOutputStream("D:\\学习资料下载\\20人成绩.txt", true);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        ) {
            //  对传入的student对象，进行数据字符串的拼接
            //  进行字符串的拼接 id=1,name=张三,age=20,className=J101
            stringBuilder.append("id = " + student.getStudentId());
            stringBuilder.append(",name = " + student.getStudentName());
            stringBuilder.append(",age = " + student.getStudentAge());
            stringBuilder.append(",className = " + student.getStudentClassName());
            //  转换成 String
            String studenInfo = new String(stringBuilder);

            //  缓冲输出到文件中，并且换行
            bufferedOutputStream.write(studenInfo.getBytes());
            bufferedOutputStream.write(System.lineSeparator().getBytes());

            //  缓冲区清除
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
