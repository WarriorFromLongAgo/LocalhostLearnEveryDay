package com.byit.JavadeIO;

import java.io.*;
//读取文件到控制台

public class ByteInputStream {
    public static void main(String[] args) throws IOException {
        caseTwo();
        //caseOne();
    }

    public static void caseOne() throws IOException {
        //定位文件位置
        File f = new File("D:/Program Files (x86)/feijm.txt");
        //FileInputStream fosTwo = new FileInputStream("D:/Program Files (x86)/feijm.txt"); //定位文件位置

        //创建字节输入流链接到文件
        InputStream inputOne = new FileInputStream(f);
        //InputStream inputOne = fosTwo;

        //创建缓冲字节流
        BufferedInputStream testTwo = new BufferedInputStream(inputOne);

        byte[] b = new byte[1024];
        int count = 0;
        int temp = 0;
        //testTwo.read();
        while ((temp = testTwo.read()) != (-1)) {
            b[count] = (byte) temp;
            count++;
        }

        testTwo.close();
        inputOne.close();

        System.out.println(new String(b));
    }

    public static void caseTwo() throws IOException {
        int i = 0;
        //字节数
        FileInputStream in = null;

        //字符串
        //InputStream inputStream = null;
        try {
            //从文件外读数据
            //字节数
            in = new FileInputStream("D:/Program Files (x86)/feijm.txt");

            //字符串
            //inputStream = new FileInputStream("D:/Program Files (x86)/feijm.txt");

        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("找不到文件位置");
            System.exit(-1);
        }
        try {

            //用于字节个数的计数
            int num = 0;
            while ((i = in.read()) != -1) {
                //将得到的ASCII码值转换成字符型
                System.out.print((char) i);
                num++;
            }
            in.close();
            System.out.println();
            System.out.println("传输字节个数：" + num);

            //读取字符串
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
//            byte[] b = new byte[1024];
//            int count = 0;
//            int temp = 0;
//            //testTwo.read();
//            while ((temp = inputStream.read()) != (-1)) {
//                b[count] = (byte) temp;
//                count++;
//            }
//            bufferedInputStream.close();
//            inputStream.close();
//            System.out.println(new String(b));
//            System.out.println("count = " + count);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("读取文件错误");
        }

    }
}
