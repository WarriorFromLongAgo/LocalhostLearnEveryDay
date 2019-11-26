package com.byit.JavadeIO;

import javafx.beans.binding.When;

import java.io.*;
import java.io.OutputStream;
//查找文件到控制台

public class ByteOutputStream {
    public static void main(String[] args) throws IOException {
        //caseOne();
        caseTwo();
    }

    public static void caseOne() throws IOException {
        File f = new File("D:/Program Files (x86)/feijm.txt");
        //FileOutputStream fosTwo = new FileOutputStream("D:/Program Files (x86)/feijm.txt");

        OutputStream outputStream = new FileOutputStream("D:/Program Files (x86)/feijm.txt");
        //OutputStream outputStream = fosTwo;

        BufferedOutputStream testThree = new BufferedOutputStream(outputStream);

        String str = "feijmh";
        byte[] b = str.getBytes();
        testThree.write(b);
        testThree.close();
        outputStream.close();
    }

    //复制和粘贴
    public static void caseTwo() throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //读取数据
            fileInputStream = new FileInputStream("D:/Program Files (x86)/fff.jpg");
            //写入数据
            fileOutputStream = new FileOutputStream("D:/Program Files (x86)/jjj.jpg");
            int count = 0;
            while ((count = fileInputStream.read()) != -1) {
                fileOutputStream.write(count);
                System.out.print((char) count);
            }
            fileInputStream.close();
            fileOutputStream.close();
            System.out.println(" 文件已复制 ");

        } catch (FileNotFoundException e) {
            System.out.println("找不到文件位置");
            System.out.println("文件复制错误");
            System.exit(-1);
        }
    }

    //  InputStream 和 OutputStream
    //
//    public static void caseThree() throws IOException {
//        // 源文件，input
//        File fileInput = new File("D:/Program Files (x86)/feijm.txt");
//        // 目标文件 out
//        File fileOutput = new File("D:/Program Files (x86)/test.txt");
//        FileInputStream fileInputStream = null;
//        FileOutputStream fileOutputStream = null;
//        try {
//            fileInputStream = new FileInputStream(fileInput);
//            fileOutputStream = new FileOutputStream(fileOutput);
//
//            // 定义一个数组 存放元素
//            byte[] bytes = new byte[1024];
//            int count = 0;
//
//            while ((count = fileInputStream.read(bytes)) != -1) {
//                fileOutputStream.write(bytes, 0, count);
//                System.out.println(new String(bytes));
//                fileOutputStream.flush();
//            }
//
//        }
//
//    }
}
