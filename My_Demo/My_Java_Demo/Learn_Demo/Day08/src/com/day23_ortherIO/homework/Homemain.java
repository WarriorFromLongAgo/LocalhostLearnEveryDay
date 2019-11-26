package com.day23_ortherIO.homework;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Homemain {

    public static void main(String[] args) {
        Map<Integer, Student> intStudentMap = creatObj();
        ObjOutPutStream(intStudentMap);
        ObjInputStream();
    }

    private static Map<Integer, Student> creatObj() {
        //  创建20个对象

        //  用来存放20个对象
        Map<Integer, Student> IntStudentMap = new HashMap<>(20);

        //  年龄处于【18---40】
        Random random = new Random();
        int age = random.nextInt(23) + 18;

        //  for循环产生20个对象
        int stuId = 10001;
        for (int i = 0; i < 20; i++) {
            Student student = new Student(stuId++, "万" + (i + 1), age);
            IntStudentMap.put(stuId, student);
        }
        return IntStudentMap;
    }


    private static void ObjOutPutStream(Map<Integer, Student> intStudentMap) {
        //  对象输出流 输出
        try (
                OutputStream outputStream = new FileOutputStream("D:\\学习资料下载\\objectout.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        ) {
            //  对传入的map集合进行遍历输出，输出的是value，也就是student对象
            for (Map.Entry<Integer, Student> intStudentEntry : intStudentMap.entrySet()) {
                objectOutputStream.writeObject(intStudentEntry.getValue());
                //  必须清空
                objectOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ObjInputStream() {
        //  读取对象文件
        try (
                InputStream inputStream = new FileInputStream("D:\\学习资料下载\\objectout.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ) {
            //  对象输入流，读取对象文件信息
            while (true) {
                try {
                    Object object = objectInputStream.readObject();
                    Student student = (Student) object;
                    System.out.println(student.toString());
                } catch (Exception e) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
