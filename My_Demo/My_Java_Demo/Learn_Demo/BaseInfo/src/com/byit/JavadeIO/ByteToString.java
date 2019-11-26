package com.byit.JavadeIO;

import java.io.*;

public class ByteToString {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/Program Files (x86)/feijm.txt");
        Reader reader = new InputStreamReader(new FileInputStream(file));

        char[] chars = new char[100];
        int length = reader.read(chars);
        System.out.println(new String(chars, 0, length));

        reader.close();
    }
}
