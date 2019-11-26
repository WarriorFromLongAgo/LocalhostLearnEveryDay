package com.day09_ru_men3;

//数组最大值 最小值
public class maxmin {
    public static void main(String[] args) {
        int[] num = {3221, 6, 6, 0, 43, 312, 7, 32, 322};
        int maxData = num[0];
        int minData = num[0];
        for (int i = 0; i < num.length; i++) {
            if (num[i] > maxData) {
                maxData = num[i];
                continue;
            } else if (num[i] < minData) {
                minData = num[i];
                continue;
            } else {
                continue;
            }

        }
        System.out.println("maxData = " + maxData + ",minData = " + minData);
    }
}
