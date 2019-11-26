package com.day22_IO_SQL.InputStreamReader;

import java.io.*;

public class InputReader {
    public static void main(String[] args) {
        try (
                FileInputStream fileInputStream = new FileInputStream("D:\\str.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        ) {
            char[] charArr = new char[1024];
            int length = 0;
            while ((length = inputStreamReader.read(charArr)) != -1) {
                System.out.println(new String(charArr, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void outputWriter() {
        String str = "asdfghjkl";
        try (
                FileOutputStream outputStream = new FileOutputStream("D:\\str.txt");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        ) {
            outputStreamWriter.write(str);
            outputStreamWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
