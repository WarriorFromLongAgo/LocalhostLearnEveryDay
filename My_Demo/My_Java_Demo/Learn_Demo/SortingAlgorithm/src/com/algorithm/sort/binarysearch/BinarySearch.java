package com.algorithm.sort.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        binarySolution();
    }

    public static void binarySolution() {
        int[] tempIntArr = new int[]{1, 3, 4, 5, 10, 30, 45, 55, 67, 81, 89, 92, 101};
        int key = 92;
        int arrIndex = binarySearch(tempIntArr, key);
        System.out.println("ArrIndex = " + arrIndex);
        System.out.println("=========================================");

    }

    /**
     * @Author: feijm
     * @Project: BinarySearch 二分查找运算
     * @Time: 2019年7月14日20:46:01
     * @version: 1.0
     * @修改原因: 无
     * middle = left+(right-left)/2
     * 如果大于middle
     * 如果小于middle
     */
    private static int binarySearch(int[] inputIntArr, int key) {
        int left = 0;
        int right = inputIntArr.length - 1;
        while (right >= left) {
            //
            int middle = left + ((right - left) / 2);
            if (key > inputIntArr[middle]) {
                left = middle + 1;
            } else if (inputIntArr[middle] > key) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}


