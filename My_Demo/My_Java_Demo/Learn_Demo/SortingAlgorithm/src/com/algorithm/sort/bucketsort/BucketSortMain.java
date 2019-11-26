package com.algorithm.sort.bucketsort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author:
 * @Project:
 * @Time:
 * @version:
 * @修改原因:
 */
public class BucketSortMain {
    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        bucketSort.buckSolution();

    }
}

class BucketSort {
    public void buckSolution() {

        //输入的数组的定义
        int[] inIntArr = {99, 32, 33, 31, 34, 31, 32, 1, 32, 33, 34};
        //排序后的数组的接收
        int[] outIntArr = this.buckSort(inIntArr);

        //打印这个outIntArr数组
        System.out.print("outIntArr = ");
        for (int i : outIntArr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    private int[] buckSort(int[] inIntArr) {
        if (inIntArr.length < 2) {
            return inIntArr;
        }
        int maxData = inIntArr[0];
        int minData = inIntArr[0];
        int inIntArrLength = inIntArr.length;

        //寻找数组的最大值，和最小值
        for (int i = 1; i < inIntArrLength; i++) {
            if (inIntArr[i] > maxData) {
                maxData = inIntArr[i];
                continue;
            } else if (inIntArr[i] < minData) {
                minData = inIntArr[i];
            } else {
                continue;
            }
        }
        //求出差值
        int differ = maxData - minData;

        //建立一个ArraryList，用来存放ArraryList，然后在每个ArraryList节点下面，定义一个ArraryList
        ArrayList<ArrayList<Integer>> buckIntArrList = new ArrayList<>();
        for (int i = 0; i < inIntArrLength; i++) {
            buckIntArrList.add(new ArrayList<>());
        }
        //每个桶的存储区间
        double storageSize = (double) differ / (double) (inIntArrLength - 1);
        //数据入桶
        for (int i = 0; i < inIntArrLength; i++) {
            int num = (int) (inIntArr[i] / storageSize) - 1;
            if (num < 0) {
                num = 0;
            }
            buckIntArrList.get(num).add(inIntArr[i]);
        }
        //桶内排序
        for (int i = 0; i < buckIntArrList.size(); i++) {
            Collections.sort(buckIntArrList.get(i));
        }
        //写入原数组
        int index = 0;
        for (ArrayList<Integer> arrayList : buckIntArrList) {
            for (Integer value : arrayList) {
                inIntArr[index] = value;
                index++;
            }
        }


        return inIntArr;
    }
}
