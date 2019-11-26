package com.byit.JavadeIO;

import java.io.*;
// 输出字符流

public class StringReaderOutPut {
    public static void main(String[] args) throws IOException {
        File f = new File("D:/Program Files (x86)/feijm.txt");
        Writer out = new FileWriter(f);
        BufferedWriter bfw = new BufferedWriter(out);

        String str = "哈哈哈";
        bfw.write(str);
        bfw.close();
        out.close();
    }
}
