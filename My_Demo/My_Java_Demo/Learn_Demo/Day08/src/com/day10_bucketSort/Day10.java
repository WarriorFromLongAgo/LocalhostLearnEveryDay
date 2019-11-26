package com.day10_bucketSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author:
 * @Project:
 * @Time:
 * @version:
 * @修改原因:
 */
public class Day10 {
    public static void main(String[] args) {
        //new对象
        ToDay toDay = new ToDay();
        //调用scannerInput函数
        int arrLength = toDay.scannerInput();
        //新建数组，长度为arrLength
        int[] arrInt = new int[arrLength];
        //调用初始化函数
        toDay.initArr(arrInt);
        //数组的排序
        toDay.bucketSort(arrInt);

        System.out.println("数组的打印，开始");
        for (int i : arrInt) {
            System.out.print(i + ",");
        }
    }
}

class ToDay {
    /**
     * @Author:
     * @Project:
     * @Time:
     * @version:
     * @修改原因: 1. 在控制台输入创建的数组的长度
     */
    public int scannerInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入输入的长度 = ");
        int arrLength = scanner.nextInt();

        return arrLength;
    }

    /**
     * @Author:
     * @Project:
     * @Time:
     * @version:
     * @修改原因: 依次在控制台输入数组每个元素的值
     */
    public void initArr(int[] arrInt) {
        //初始化数组，
        //每一位都进行初始化赋值
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arrInt.length; i++) {
            System.out.print("请输入第" + (i + 1) + "个数 = ");
            arrInt[i] = scanner.nextInt();
        }
    }

    /**
     * @Author:
     * @Project:3
     * @Time:
     * @version:
     * @修改原因:
     */
    public void bucketSort(int[] inArrInt) {
        //特殊处理，数组为1的长度
        if (inArrInt.length < 2) {
            System.out.println("数组长度为1，返回");
            return;
        }
        //数组的最大值，最小值
        int maxData = inArrInt[0];
        int minData = inArrInt[0];
        int inArrIntLength = inArrInt.length;
        for (int i = 0; i < inArrIntLength; i++) {
            if (inArrInt[i] > maxData) {
                maxData = inArrInt[i];
            } else if (inArrInt[i] < minData) {
                minData = inArrInt[i];
            } else {
                continue;
            }
        }
        int differ = maxData - minData;

        //新建一个数组，并且在每个数组里面
        ArrayList<ArrayList<Integer>> bucketArrList = new ArrayList<>();
        for (int i = 0; i < inArrIntLength; i++) {
            bucketArrList.add(new ArrayList<>());
        }
        //每个桶的存储区间
        double storageSize = (double) differ / (double) (inArrIntLength - 1);

        //将待排序的数组，依次放入数组内部的桶里面
        for (int i = 0; i < inArrIntLength; i++) {
            int index = (int) (inArrInt[i] / storageSize) - 1;
            if (index < 0) {
                index = 0;
            }
            bucketArrList.get(index).add(inArrInt[i]);
        }
        //对于数组内部的数组，进行排序
        for (int i = 0; i < bucketArrList.size(); i++) {
            Collections.sort(bucketArrList.get(i));
        }

        //修改原数组
        int index = 0;
        for (ArrayList<Integer> arrayList : bucketArrList) {
            for (Integer integer : arrayList) {
                inArrInt[index] = integer;
                index++;
            }
        }
    }
}

