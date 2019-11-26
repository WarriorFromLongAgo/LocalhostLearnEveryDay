package com.day23_ortherIO.getconding;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class GbkUtf {
    public static void main(String[] args) {
//        gbkgbk();
//        inputReader();
//        output();
        input2();
    }

    //  修改的方法为，直接修改文本的格式
    //  或者修改程序的格式

    //ANSI 转为 UTF-8
    //123
    //abc
    //С����
    private static void gbkgbk() {
        //  new String(byteArr, 0, inputLen, "utf-8")
        //  new String(byteArr, 0, inputLen, "gbk")
        try (
                InputStream inputStream = new FileInputStream("D:\\学习资料下载\\day23demo.txt");

        ) {
            int inputLen;
            byte[] byteArr = new byte[1024];
            while ((inputLen = inputStream.read(byteArr)) != -1) {
                System.out.println(new String(byteArr, 0, inputLen, "utf-8"));
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void inputReader() {
        try (
                InputStream inputStream = new FileInputStream("D:\\学习资料下载\\day23demo.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        ) {
            int readLength;
            char[] charArr = new char[1024];
//            utf-8
//            123
//            abc
//            С���
            readLength = inputStreamReader.read(charArr);
            for (int i = 0; i < readLength; i++) {
                System.out.print(charArr[i]);
            }
            System.out.println();
//            gbk
//            123
//            abc
//            小幸运
//            int readLength2;
//            while ((readLength2 = inputStreamReader.read(charArr)) != -1) {
//                System.out.println(new String(charArr));
//            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void output() {
        //  文件是UTF-8，name输出也是小幸运
        String str = "小幸运";
        try {
            byte[] byteArr = str.getBytes("utf-8");
            OutputStream outputStream = new FileOutputStream("D:\\学习资料下载\\day23print.txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(byteArr);
            System.out.println(new String(byteArr));
            bufferedOutputStream.flush();
            bufferedOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void input() {
        try (
                InputStream inputStream = new FileInputStream("D:\\学习资料下载\\day23print.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "gbk");
        ) {
            int inLength;
            char[] charArr = new char[1024];

            while ((inLength = inputStreamReader.read(charArr)) != -1) {
                System.out.println(new String(charArr));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void input2() {
        try (
                InputStream inputStream = new FileInputStream("D:\\学习资料下载\\day23demo.txt");
                OutputStream outputStream = new FileOutputStream("D:\\学习资料下载\\day23print.txt");
        ) {
            int inLength;
            byte[] byteArr = new byte[1024];
            String s = "";
            while ((inLength = inputStream.read(byteArr)) != -1) {
                s = new String(byteArr, 0, inLength, "gbk");
            }
            System.out.println(s);
            byte[] bytes = s.getBytes("utf-8");
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
