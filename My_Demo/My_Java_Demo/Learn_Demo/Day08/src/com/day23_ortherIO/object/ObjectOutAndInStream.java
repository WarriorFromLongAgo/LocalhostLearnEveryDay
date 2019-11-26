package com.day23_ortherIO.object;

import java.io.*;

public class ObjectOutAndInStream {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        Student stuOne = new Student(10000, "aaa");
        Student stuTwo = new Student(10001, "bbb");
        Student stuThree = new Student(10002, "ccc");

        objectOutput(stuOne);
        objInput();
    }

    private static void objectOutput(Student student) throws IOException {
        OutputStream outputStream = new FileOutputStream("D:\\学习资料下载\\objectout.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//        byte[] byteArr = new byte[]{97, 98};
//        objectOutputStream.write(byteArr);
//        objectOutputStream.flush();
//        objectOutputStream.close();
        objectOutputStream.writeObject(student);
        outputStream.flush();
        outputStream.close();
    }

    private static void objInput() throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream("D:\\学习资料下载\\objectout.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);


        while (true) {
            try {
                Object object = objectInputStream.readObject();
                System.out.println((Student) object);
            }catch (Exception e){
                break;
            }

        }
    }
}
