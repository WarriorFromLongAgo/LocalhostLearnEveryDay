package com.day17_Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeWorkThree {
    public static void main(String[] args) {
//        mathRandom();
        mathNextInt();
    }

    public static void mathRandom() {
        //循环300次
        for (int i = 0; i < 300; i++) {
            double tempDouble = Math.random();
            //      [0,1)
            tempDouble = tempDouble * 39;
            tempDouble = Math.floor(tempDouble);
            tempDouble = tempDouble + 21;
            System.out.print((int) tempDouble + ",");

            //每打20个换一行
            if (i >= 20 && i % 20 == 0) {
                System.out.println();
            }
            //判断是否存在不符合题目的数
            if (tempDouble > 59 || tempDouble < 21) {
                System.out.println(" 题目做错啦 ");
                break;
            }
        }
    }

    public static void mathNextInt() {

        for (int i = 0; i < 300; i++) {
            List<Integer> listArrInt = new ArrayList<>();

            Random random = new Random();
            //      [0,38]
            int tempDouble = random.nextInt(39);
            tempDouble = tempDouble + 21;
            System.out.print((int) tempDouble + ",");

            //每打20个换一行
            if (i >= 20 && i % 20 == 0) {
                System.out.println();
            }
            if (tempDouble > 58) {
                listArrInt.add(tempDouble);
                System.out.println(listArrInt.toString());
            }
            //判断是否存在不符合题目的数
            if (tempDouble > 59 || tempDouble < 21) {
                System.out.println(" 题目做错啦 ");
                break;
            }
        }
    }
}
