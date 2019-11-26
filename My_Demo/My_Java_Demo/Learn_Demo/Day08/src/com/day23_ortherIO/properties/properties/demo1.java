package com.day23_ortherIO.properties.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class demo1 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
//        Properties properties1 = new Properties("11111");
        properties.setProperty("10000", "11111");
        properties.setProperty("20000", "22222");
        properties.setProperty("30000", "33333");
        properties.setProperty("40000", "44444");
        properties.setProperty("50000", "55555");

//        System.out.println(properties.getProperty("10000"));
//        System.out.println(properties.getProperty("60000", "nullsq"));

//        properties.setProperty("10000", "10000");
//        for (Map.Entry<Object, Object> StrStrPropertiesEntry : properties.entrySet()) {
//            System.out.print("key = " + StrStrPropertiesEntry.getKey());
//            System.out.println(",,value = " + StrStrPropertiesEntry.getValue());
//        }
//        System.out.println();
//        for (Object key : properties.keySet()) {
//            System.out.print("key = " + key);
//            System.out.println(",,value = " + properties.getProperty(key.toString()));
//        }

        //  如果FileOutputStream不加true，一次程序store几次，就会在后面累加、。
        //  如果FileOutputStream加true，则会一直始终累加
//        OutputStream outputStream = new FileOutputStream("D:\\学习资料下载\\day23demo.properties");
//        properties.store(outputStream, null);
//        properties.store(outputStream, null);
//
//        properties.store(outputStream, "day23天");
//        properties.store(outputStream, "day23天");
//        Writer writer = new FileWriter("D:\\学习资料下载\\day23demo.properties");
//        properties.store(writer,null);
//        properties.store(writer,"day23天天天天");

        Properties propertiesTemp = new Properties();
//        Reader reader = new FileReader("D:\\学习资料下载\\day23demo.properties");
//        propertiesTemp.load(reader);
//        reader.close();
//        for (Map.Entry<Object, Object> strStrpropertiesEntry : propertiesTemp.entrySet()) {
//            System.out.print("key = " + strStrpropertiesEntry.getKey());
//            System.out.println(",,value = " + strStrpropertiesEntry.getValue());
//        }
//        System.out.println(propertiesTemp);

        Properties propertiesTwo = new Properties();
        InputStream inputStream = new FileInputStream("D:\\java编\\答案 100分.txt");
        propertiesTwo.load(inputStream);
        inputStream.close();
        for (Map.Entry<Object, Object> strStrpropertiesEntry : propertiesTwo.entrySet()) {
            System.out.print("key = " + strStrpropertiesEntry.getKey());
            System.out.println(",,value = " + strStrpropertiesEntry.getValue());
        }
//        PrintStream printStream = new PrintStream("D:\\学习资料下载\\day23demo.properties");
//        properties.list(printStream);
//        for (Map.Entry<Object, Object> strStrpropertiesEntry : properties.entrySet()) {
//            System.out.print("key = " + strStrpropertiesEntry.getKey());
//            System.out.println(",,value = " + strStrpropertiesEntry.getValue());
//        }
//        for (String string : properties.stringPropertyNames()) {
//            System.out.println("key = " + string);
//            System.out.println("value = " + properties.getProperty(string));
//        }
//        for (Object o : properties.keySet()) {
//
//        }
    }
}
