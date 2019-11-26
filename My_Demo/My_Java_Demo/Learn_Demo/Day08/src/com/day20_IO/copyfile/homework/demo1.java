package com.day20_IO.copyfile.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @Author: feijm
 * @Project: 分数统计
 * @Time: 2019年8月4日12:08:02
 * @version: 1.0.0
 * @修改原因:
 */
public class demo1 {
    public static void main(String[] args) {
        //  用来存放学生对象
        List<student> studentList = new ArrayList<>();
        //  找到存放成绩的文件夹
        File fileName = new File("D:\\java101\\一班");
        //  得到所有的文件的目录，格式如右所示：D:\分数统计\万一 50分.txt
        File[] fileArr = readListFiles(fileName);

        //  对答案进行单独的处理，并且存进单独的map里面
        File fileAnswerName = new File("D:\\java101\\答案 75分.txt");
        Map<String, String> answerStrStrMap = readTxt(fileAnswerName);

        //  根据上面得到的目录，遍历所有的学生成绩
        for (File file : fileArr) {
            System.out.print(file.getName());
            //  得到单个人的map
            Map<String, String> everyoneStrStrMap = readTxt(file);

            //  调用函数，传入答案map和个人的map，得到成绩
            double score = getScore(everyoneStrStrMap, answerStrStrMap);
            System.out.println(" 的成绩 = " + score);
            //  切割后，存进studentList里面
            String[] twoSplit = file.getName().split("\\.", 2);
            studentList.add(new student(twoSplit[0], score));
        }
        //  根据学生的成绩进行排序
        Collections.sort(studentList, new Comparator<student>() {
            @Override
            public int compare(student o1, student o2) {
                if (o1.getScore() < o2.getScore()) {
                    return 1;
                } else if (o1.getScore() > o2.getScore()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });


        int rank = 1;
        for (int i = 0; i < studentList.size(); i++) {
            System.out.print("第" + rank + "名是 ");
            System.out.print(studentList.get(i).getName());
            System.out.print(",他的成绩是 = ");
            System.out.println(studentList.get(i).getScore());
            rank++;
        }

    }

    private static File[] readListFiles(File fileName) {
        File[] fileArr = fileName.listFiles();

        for (File file : fileArr) {
//            System.out.println(file);
            String name = file.getName();
//            System.out.println(name);
        }
        return fileArr;
    }

    //  得到单个txt文件的详细信息
    private static Map<String, String> readTxt(File fileName) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        Map<String, String> everyOneStrStrtMap = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            everyOneStrStrtMap = new HashMap<>();
            String str = "";
            String space = " ";
            while ((str = bufferedReader.readLine()) != null) {
                String[] split = str.split(space, 2);
                split[1] = split[1].trim();
                split[1] = split[1].toUpperCase();
                everyOneStrStrtMap.put(split[0], split[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return everyOneStrStrtMap;
    }

    private static double getScore(Map<String, String> everyOneMap, Map<String, String> answerMap) {
        double score = 0;
        //  对于单选题进行特殊处理
        String one = "1-5";
        String two = "6-10";

        Set<Map.Entry<String, String>> everyOneEntrySet = everyOneMap.entrySet();

        //  遍历输入的每个学生的成绩key
        for (Map.Entry<String, String> everyOneStrStrEntry : everyOneEntrySet) {
            //
            String everyOneStr = everyOneStrStrEntry.getValue();
            String anwserStr = answerMap.get(everyOneStrStrEntry.getKey());

            if (everyOneStrStrEntry.getKey().equals(one) || everyOneStrStrEntry.getKey().equals(two)) {
                for (int i = 0; i < everyOneStr.length(); i++) {
                    if (everyOneStr.equals(anwserStr)) {
                        score = score + 5 * 5;
                        break;
                    }
                    if (everyOneStr.charAt(i) == anwserStr.charAt(i)) {
                        score += 5;
                    }
                }
            } else {
                if (everyOneStr.equals(anwserStr)) {
                    score += 5;
                }
            }
        }

        return score;
    }
}
