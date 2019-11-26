package com.day20_IO.copyfile;

import java.io.*;

public class copyFileInput {
    public static void main(String[] args) {
        File inputFile = new File("D:\\出师表.txt");
        File outCopyFile = new File("D:\\出师表的赋值.txt");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            inputStream = new FileInputStream(inputFile);
            outputStream = new FileOutputStream(outCopyFile);
            byte[] byteArr = new byte[1024];
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            int len = 0;
            while ((len = bufferedInputStream.read(byteArr)) != -1) {
//                bufferedOutputStream.write(byteArr, 0, len);
                System.out.println(new String(byteArr, 0, len));
//                bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
