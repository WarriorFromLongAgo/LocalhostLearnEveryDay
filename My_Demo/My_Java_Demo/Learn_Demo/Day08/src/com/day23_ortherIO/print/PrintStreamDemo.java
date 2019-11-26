package com.day23_ortherIO.print;

import java.io.*;

public class PrintStreamDemo {
    public static void main(String[] args) {
        File fileName = new File("D:\\学习资料下载\\day23demo.txt");
        try (
                OutputStream outputStream = new FileOutputStream("D:\\学习资料下载\\day23demo.txt");
        ) {
            PrintStream printStream = new PrintStream(fileName);
            PrintStream printStream1 = new PrintStream(outputStream);
            PrintStream printStream2 = new PrintStream(outputStream, true);
            PrintStream printStream3 = new PrintStream(outputStream, true, "utf-8");
            PrintStream printStream4 = new PrintStream("D:\\学习资料下载\\day23demo.txt");

            //  aaaaababcdefgh
//            for (char c : "aaaaa".toCharArray()) {
//                printStream.append(c);
//            }
//            printStream.append("bbbbb".charAt(1));
//            printStream.print("abcdefgh");
//            printStream.flush();
//            printStream.close();

            //  abcdefgh
//            printStream.print("abcdefgh");
//            printStream.flush();
//            printStream.close();

//            ab
//            printStream.write(1);
//            byte[] byteArr = new byte[]{97, 98};
//            printStream.write(byteArr);
//            printStream.flush();
//            printStream.close();

//            1true6ab77.77
//            8.899aaabbb
//            boolean flag = true;
//            char[] charArr = new char[]{'a', 'b'};
//            double dou = 77.77;
//            float f = 8.8F;
//            long l = 99L;
//            Object o = "aaa";
//            printStream.print(1);
//            printStream.print(flag);
//            printStream.print('6');
//            printStream.print(charArr);
//            printStream.print(dou);
//            printStream.println();
//            printStream.print(f);
//            printStream.print(l);
//            printStream.print(o);
//            printStream.print("bbb");
//            printStream.flush();
//            printStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
