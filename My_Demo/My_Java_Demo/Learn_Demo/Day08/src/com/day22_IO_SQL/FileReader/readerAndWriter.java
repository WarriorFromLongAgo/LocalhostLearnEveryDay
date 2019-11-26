package com.day22_IO_SQL.FileReader;

import java.io.*;

public class readerAndWriter {
    public static void main(String[] args) {

    }

    private static void writerOne() {
        String str = "qwertyuiop" + System.lineSeparator() + "asdfghjkl" + System.lineSeparator() + "zxcvbnm";
        try (Writer writer = new FileWriter(new File("D:\\str.txt"))) {
            writer.write(str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile() {
        try (
                FileReader fileReader = new FileReader(new File("D:\\出师表.txt"));
                FileWriter fileWriter = new FileWriter(new File("D:\\出师表的赋值.txt"));
        ) {
            char[] charArr = new char[1024];
            int length = 0;
            while ((length = fileReader.read(charArr)) != -1) {
                fileWriter.write(charArr, 0, length);
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
