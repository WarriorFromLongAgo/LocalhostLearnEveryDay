package com.day20_IO.copyfile.homework;

public class cangshi {
    public static void main(String[] args) {
        //  D:\java编\JAVA101\一班\费久猛 0分.txt
        String tempFile = "D:\\java编\\JAVA101\\一班\\费久猛 0分.txt";
        String[] split = tempFile.split("\\\\");
        for (String string : split) {
            System.out.println(string);
        }


    }

//    private static void readAnswer() {
//        FileReader fileReader = null;
//        BufferedReader bufferedReader = null;
//        try {
//            fileReader = new FileReader(new File("D:\\分数统计\\答案.txt"));
//            bufferedReader = new BufferedReader(fileReader);
//            Map<String, String> singleResultMap = new HashMap<>();
//            String str = "";
//            String space = " ";
//            while ((str = bufferedReader.readLine()) != null) {
//                String[] split = str.split(space, 2);
//                split[1] = split[1].trim();
//                singleResultMap.put(split[0], split[1]);
//            }
//            for (Map.Entry<String, String> stringStringEntry : singleResultMap.entrySet()) {
//                System.out.println("key = " + stringStringEntry.getKey());
//                System.out.println("value = " + stringStringEntry.getValue());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    private static void method1() {
//        String w = "1-5 ABCD";
//        String ww = "1-5      ABC    ";
//        String[] s = w.split(" ");
//        String[] s1 = ww.split(" ", 2);
//        int count = 1;
//
//        for (String string : s) {
//            //  次数
//            System.out.println("第" + count++ + "次");
//            System.out.println(string);
//        }
//        System.out.println();
//
//        int count2 = 1;
//        s1[1] = s1[1].trim();
//        for (String string : s1) {
//            //  次数
//            System.out.println("第" + count2++ + "次");
//            System.out.println(string);
//        }
//        if (s[1].equals(s1[1])) {
//            System.out.println("true");
//        } else {
//            System.out.println("flases");
//        }
//    }
}
