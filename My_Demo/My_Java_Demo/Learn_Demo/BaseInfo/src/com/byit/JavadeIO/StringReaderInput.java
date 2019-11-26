package com.byit.JavadeIO;

import java.io.*;

/*
 *   CharReader、StringReader是两种基本的介质流，它们分别将Char数组、String中读取数据
 *   PipedReader 是从与其它线程共用的管道中读取数据。
 *   BufferedReader 很明显就是一个装饰器，它和其子类负责装饰其它Reader 对象。
 *   FilterReader 是所有自定义具体装饰流的父类，其子类PushbackReader对Reader对象进行装饰，会增加一个行号。
 *   InputStreamReader 是一个连接字节流和字符流的桥梁，它将字节流转变为字符流。
 *   FileReader可以说是一个达到此功能、常用的工具类，在其源代码中明显使用了将FileInputStream 转变为Reader 的方法
 *
 *
 *
 * */

//字符流   读取长度 与 读取数据

public class StringReaderInput {
    public static void main(String[] args) throws IOException {
        caseTwo();
    }

    public static void caseOne() throws IOException {
        File f = new File("D:/Program Files (x86)/feijm.txt");
        char[] chars = new char[100];

        Reader reader = new FileReader(f);
        BufferedReader bfr = new BufferedReader(reader);
        int count = bfr.read(chars);

        bfr.close();
        reader.close();
        System.out.println("count长度 = " + count);
        System.out.println("内容为 = " + new String(chars, 0, count));
    }

    // （字符流缓冲区读写文件-高效，仅限文本文件）
    public static void caseTwo() throws IOException {
        // reader 源文件 读取文件
        File fReader = new File("D:/Program Files (x86)/feijm.txt");
        // witer 目标文件，写入文件
        File fWriter = new File("D:/Program Files (x86)/test.txt");
        FileWriter fileWriter = new FileWriter(fWriter);
        FileReader fileReader = new FileReader(fReader);

        BufferedWriter bufferWriter = null;
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(fileReader);
            bufferWriter = new BufferedWriter(fileWriter);
            String line = "";
            while ((line = bufferReader.readLine()) != null) {
                bufferWriter.write(line);
                System.out.println(line);
                bufferWriter.newLine();
                bufferWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferWriter.close();
                bufferReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
