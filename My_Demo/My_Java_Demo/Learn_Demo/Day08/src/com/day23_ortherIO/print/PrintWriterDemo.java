package com.day23_ortherIO.print;

import java.io.*;

public class PrintWriterDemo {
    public static void main(String[] args) {
        File fileName = new File("D:\\学习资料下载\\day23demo.txt");
        try (
                Writer writer = new FileWriter("D:\\学习资料下载\\day23demo.txt");
                OutputStream outputStream = new FileOutputStream("D:\\学习资料下载\\day23demo.txt");
        ) {

            PrintWriter printWriter = new PrintWriter(fileName);
            PrintWriter printWriter1 = new PrintWriter(outputStream);
            PrintWriter printWriter2 = new PrintWriter(outputStream, true);
            PrintWriter printWriter3 = new PrintWriter("D:\\学习资料下载\\day23demo.txt");
            PrintWriter printWriter4 = new PrintWriter(writer);
            PrintWriter printWriter5 = new PrintWriter(writer, true);

            //  aaaaababcdefgh
//            for (char c : "aaaaa".toCharArray()) {
//                printWriter.append(c);
//            }
//            printWriter.append("bbbbb".charAt(1));
//            printWriter.print("abcdefgh");
//            printWriter.flush();
//            printWriter.close();

            //  abcdefgh
//            printWriter.print("abcdefgh");
//            printWriter.flush();
//            printWriter.close();

            //  asdfghjkl
//            printWriter.write("asdfghjkl");
//            printWriter.flush();
//            printWriter.close();

            //  sllllllllll
//            printWriter.write(1);
//            printWriter.write('s');
//            printWriter.write("llllllllll");
//            printWriter.flush();
//            printWriter.close();

            //  
            printWriter.write(1);
            printWriter.flush();
            printWriter.close();

//            1true2345677.77
//            8.899aaabbb
//            boolean flag = true;
//            char[] charArr = new char[]{'2', '3', '4', '5'};
//            double dou = 77.77;
//            float f = 8.8F;
//            long l = 99L;
//            Object o = "aaa";
//            printWriter5.print(1);
//            printWriter5.print(flag);
//            printWriter5.write(charArr);
//            printWriter5.print('6');
//            printWriter5.print(dou);
//            printWriter5.println();
//            printWriter5.print(f);
//            printWriter5.print(l);
//            printWriter5.print(o);
//            printWriter5.print("bbb");
//            printWriter5.flush();
//            printWriter5.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
