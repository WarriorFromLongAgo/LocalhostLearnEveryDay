package com.day20_IO.inputstream;

import java.io.*;
import java.nio.file.Files;

public class InputStreamOne {
    public static void main(String[] args) {

    }

    private static void inStreamTwo() {
        String filename = "D:\\电脑必备\\one\\oneone.txt";
        byte[] byteAll = null;
        try {
            byteAll = Files.readAllBytes(new File(filename).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(byteAll));
    }

    private static void inStream() {
        File fileInput = new File("D:\\one.txt");
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            inputStream = new FileInputStream(fileInput);
            bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] byteArr = new byte[1024];
            int count = 0;

            while ((count = bufferedInputStream.read(byteArr)) != -1) {
                System.out.println(new String(byteArr, 0, count));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(" 完成 ");
        }
    }
}
