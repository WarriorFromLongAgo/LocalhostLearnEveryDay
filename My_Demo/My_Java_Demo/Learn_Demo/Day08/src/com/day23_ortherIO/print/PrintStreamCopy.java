package com.day23_ortherIO.print;

import java.io.*;

public class PrintStreamCopy {
    public static void main(String[] args) {
        try (
                InputStream inputStream = new FileInputStream("D:\\学习资料下载\\day23demo.txt");
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                PrintStream printStream = new PrintStream("D:\\学习资料下载\\day23print.txt");
        ) {
            byte[] byteArr = new byte[1024];
            int inputLength = 0;

            while ((inputLength = bufferedInputStream.read(byteArr)) != -1) {
                printStream.write(byteArr, 0, inputLength);
            }
            System.out.println(new String(byteArr, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
