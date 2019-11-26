package com.algorithm.sort.insertsort;

import java.util.ArrayList;

public class InsertSort {
    public static void main(String[] args) {
        insertSolution();
    }

    public static void insertSolution() {
        int[] tempIntArr = new int[]{55, 51, 90, 11, 20, 5, 1, 85};
        ArrayList<Integer> tempInt = new ArrayList<Integer>();
        //100    5
        //1000   50
        //10000  800-900
        for (int i = 100; i > 0; i--) {
            tempInt.add(i);
        }
//        for (int i = 0; i < tempIntArr.length; i++) {
//            tempInt.add(tempIntArr[i]);
//        }
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> outputIntArr = insertSort(tempInt);
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("time = " + time + "ms");
        for (int x : outputIntArr) {
            System.out.print(x + "，");
        }
        System.out.println();
        System.out.println("=======================================");
    }

//    @Override
//    public int compare(Object o1, Object o2) {
//        int TempO1 = (int) o1;
//        int TempO2 = (int) o2;
//
//        if (TempO1 > TempO2) {
//            return 1;
//        } else if (TempO1 < TempO2) {
//            return -1;
//        }
//        else {
//            return 0;
//        }
//    }

    /**
     * @Author: feijm
     * @Project: insertSort
     * @Time: 2019年7月15日15:49:23
     * @version: 1.0
     * @修改原因: 无
     * <p>
     * 空间复杂度：On用于存放排序的数组
     * 时间复杂度：On^2
     *
     * <p>
     * 建立一个排序完成的区间，将未排序的元素，有序的放入已排序的区域，
     * 如果发现一个很少的元素，，则进行前移操作，，发现排序完成时，进行break
     * | 6 3 5 7 0
     * 6            | 3 5 7 0
     * 6 3          | 5 7 0
     * 3 6          | 5 7 0
     * 3 6 5        | 7 0
     * 3 5 6        | 7 0
     * 3 5 6 7      | 0
     * 3 5 6 7 0
     * 3 5 6 0 7
     * 3 5 0 6 7
     * 3 0 5 6 7
     * 0 3 5 6 7
     */
    private static ArrayList<Integer> insertSort(ArrayList<Integer> inputIntArr) {
        if (inputIntArr.size() < 2) {
            return inputIntArr;
        }
        int num = 0;

        for (int i = 1; i < inputIntArr.size(); i++) {
            for (int j = i; j > 0; j--) {
                num++;
                if (inputIntArr.get(j - 1) > inputIntArr.get(j)) {
                    int tempInt = inputIntArr.get(j);
                    inputIntArr.set(j, inputIntArr.get(j - 1));
                    inputIntArr.set(j - 1, tempInt);
                } else {
                    break;
                }
            }
            //System.out.print("insertSort = ");

//            for (int x : inputIntArr) {
//                System.out.print(x + "，");
//            }
//            System.out.println();
        }
        //System.out.println("运行了 = " + num);
        return inputIntArr;
    }
}
