package com.algorithm.sort.selectsort;

public class SelectSort {
    public static void main(String[] args) {
        selectSolution();
    }
    public static void selectSolution() {
        int[] tempInt = new int[]{55, 51, 90, 11, 20, 5, 1, 85};
        int[] outputIntArr = selectSort(tempInt);
        System.out.println("原来的数组 = {55, 51, 90, 11, 20, 5, 1, 85};");
        System.out.print("selectSort = ");
        for (int i : outputIntArr) {
            System.out.print(i + "，");
        }
        System.out.println();
        System.out.println("=======================================");
    }

    /**
     * @Author:
     * @Project:
     * @Time:
     * @version:
     * @修改原因: 第一位 和 后面的进行对比，
     * 每一次运行都要将一个剩余待分配的最小值，放在数组的开头。
     * 6 3 5 7 0   6-3比较
     * 3 6 5 7 0   3-5比较
     * 3 6 5 7 0   3-7比较
     * 0 6 5 7 3   3-0比较
     * 0 6 5 7 3   6-5
     * 0 5 6 7 3   5-7
     * 0 5 6 7 3   5-3
     * 0 3 6 7 5   6-7
     * 0 3 6 7 5   6-5
     * 0 3 5 7 6   7-6
     * 0 3 5 6 7
     * 数组的长度就是时间复杂度
     * 时间复杂度：O(n^2) 空间复杂度O(n)
     */
    private static int[] selectSort(int[] inputIntArr) {
        if (inputIntArr.length < 2) {
            return inputIntArr;
        }
        int num = 0;

        for (int i = 0; i < inputIntArr.length - 1; i++) {
            for (int j = i + 1; j < inputIntArr.length; j++) {
                num++;
                if (inputIntArr[i] > inputIntArr[j]) {
                    int temp = inputIntArr[i];
                    inputIntArr[i] = inputIntArr[j];
                    inputIntArr[j] = temp;
                }
            }
        }
        System.out.println("运行了 = " + num);
        return inputIntArr;
    }
}
