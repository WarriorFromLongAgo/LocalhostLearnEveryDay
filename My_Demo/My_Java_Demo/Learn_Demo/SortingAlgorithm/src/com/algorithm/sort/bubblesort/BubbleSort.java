package com.algorithm.sort.bubblesort;

public class BubbleSort {
    public static void main(String[] args) {
        bubbleSolution();
    }

    public static void bubbleSolution() {
        int[] tempInt = new int[]{55, 51, 90, 11, 20, 5, 1, 85};
        int[] outputIntArr = bubbleSort(tempInt);
        System.out.print("bubbleSort = ");
        for (int i : outputIntArr) {
            System.out.print(i + "，");
        }
        System.out.println();
        System.out.println("=========================================");

    }

    /**
     * @Author: feijm
     * @Project: bubbleSort 冒泡排序
     * @Time: 2019年7月15日10:15:39
     * @version: 1.0
     * @修改原因: 无
     * @特点：多次移动元素，多次比较元素
     * @优点：比较起来比较简单，空间复杂度低， 稳定的排序算法
     * @缺点：时间复杂度很高， 时间复杂度：On^2
     * 空间复杂度：On^1
     * <p>
     * 比较相邻的元素，如果当前的元素大于后面的元素，则进行交换。否则不进行交换。
     * 6 3 5 7 0 6-3
     * 3 6 5 7 0 6-5
     * 3 5 6 7 0 6-7
     * 3 5 6 7 0 7-0
     * 3 5 6 0 7 3-5
     * 3 5 6 0 7 5-6
     * 3 5 6 0 7 6-0
     * 3 5 0 6 7 6-7
     * 3 5 0 6 7 3-5
     * 3 0 5 6 7 5-0
     * 0 3 5 6 7 3-0
     */
    private static int[] bubbleSort(int[] inputIntArr) {
        if (inputIntArr.length < 2) {
            return inputIntArr;
        }
        int inputIntArrLength = inputIntArr.length;
        int num = 0;
        for (int i = 0; i < inputIntArrLength - 1; i++) {
            for (int j = 0; j < inputIntArrLength - 1 - i; j++) {
                num++;
                if (inputIntArr[j] > inputIntArr[j + 1]) {
                    int tempInt = inputIntArr[j + 1];
                    inputIntArr[j + 1] = inputIntArr[j];
                    inputIntArr[j] = tempInt;
                }
            }
        }
        System.out.println("执行次数 num = " + num);
        //  28次
        return inputIntArr;
    }
}
