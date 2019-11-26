package com.day22_IO_SQL.tryClose;

import java.io.*;
import java.util.Random;

public class tryClose {
    public static void main(String[] args) {
        one();
    }

    private static void moth1() {
        try (
                InputStream inputStream = new FileInputStream(new File("D:\\java101\\二班\\费久猛 0分.txt"));
                OutputStream outputStream = new FileOutputStream(new File("D:\\java101\\copy 费久猛 0分.txt"));
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        ) {
            int length = 0;
            byte[] byteArr = new byte[1024];
            while ((length = bufferedInputStream.read(byteArr)) != -1) {
                bufferedOutputStream.write(byteArr, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void one() {
        Random random = new Random();
        for (int i = 1; i < 300; i++) {
            int j = random.nextInt(23) + 18;
            System.out.print(j + ",");
            if (i % 20 == 0) {
                System.out.println();
            }
            if (j < 18 || j > 40) {
                System.out.println(" 错误 ");
            }
            if (j == 18 || j == 40) {
                System.out.println();
                System.out.println("发现" + j);
            }
        }
        System.out.println();


    }
}
