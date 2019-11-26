package com.day22_IO_SQL.day22homework.iodeal;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class readIO {
    public void readToConsole() {
        inputStreamConsole();
    }

    private void inputStreamConsole() {
        try (
                Reader reader = new FileReader("D:\\学习资料下载\\20人成绩.txt");
                BufferedReader bufferedReader = new BufferedReader(reader);
        ) {
            List<Object> objectList = new ArrayList<>();

            String studentInfo = bufferedReader.readLine();
            String[] oneSplit = studentInfo.split("\\,");
            for (int i = 0; i < oneSplit.length; i++) {
//                System.out.println(split[i]);
                String[] twoSplit = oneSplit[i].split("\\=");

                String[] threeSplit = twoSplit[twoSplit.length - 1].split(" ");
                objectList.add(threeSplit[threeSplit.length - 1]);
            }
            for (int i = 0; i < objectList.size(); i++) {
                System.out.print(objectList.get(i) + ",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
