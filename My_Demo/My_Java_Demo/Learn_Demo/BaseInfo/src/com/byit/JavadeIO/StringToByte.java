package com.byit.JavadeIO;
/*
* 字符流和字节流的转换
* 转换流的特点：
*（1）其是字符流和字节流之间的桥梁
 （2）可对读取到的字节数据经过指定编码转换成字符
 （3）可对读取到的字符数据经过指定编码转换成字节
* 何时使用转换流：
*       1，当字节和字符需要转换时，
*       2，流操作的数据需要解码，或编码时
* 具体的操作对象类，InputStreamReader:字节到字符的桥梁   OutputStreamWriter:字符到字节的桥梁
* */

import java.io.*;
import java.util.*;

public class StringToByte {
    public static void main(String[] args) throws IOException {

        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
    }

    private static void mothod2() {
        Map<String, String> OneMap = new HashMap<>();
        Map<String, String> AnwserMap = new HashMap<>();
        OneMap.put("1-5", "11111");
        AnwserMap.put("1-5", "11111");
        OneMap.put("22", "22");
        AnwserMap.put("22", "22");

        Set<Map.Entry<String, String>> oneEntry = OneMap.entrySet();

        for (Map.Entry<String, String> oneStrStrEntry : oneEntry) {

            String value = oneStrStrEntry.getValue();
            String anwserValue = AnwserMap.get(oneStrStrEntry.getKey());

            System.out.println("oneStrStrEntry.getValue() = " + value);
            System.out.println("AnwserMap.get(oneStrStrEntry.getKey()) = " + anwserValue);


        }

//        File file = new File("D:/Program Files (x86)/feijm.txt");
//        Writer out = new OutputStreamWriter(new FileOutputStream(file));
//        out.write("hellllllllllo  fuck");
//        out.close();
    }
}
