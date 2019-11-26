package com.algorithm.sort.mergetsort;

public class MergeSort {
    public static void main(String[] args) {
        int[] num = {31, 43, 12, 88, 13, 34, 54, 97, 13};
        int[] output = mergeSort(num);
        for (int i : output) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static int[] mergeSort(int[] intArr) {
        int right = intArr.length;
        int[] outIntArr = new int[right];
        int block, left;

        // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
        for (block = 1; block < right; block *= 2) {
            for (left = 0; left < right; left += 2 * block) {
                int low = left;
                int mid = (left + block) < right ? (left + block) : right;
                int high = (left + 2 * block) < right ? (left + 2 * block) : right;
                //两个块的起始下标及结束下标
                int startOne = low, endOne = mid;
                int startTwo = mid, endTwo = high;
                //开始对两个block进行归并排序
                while (startOne < endOne && startTwo < endTwo) {
                    outIntArr[low++] = (intArr[startOne] < intArr[startTwo]) ? intArr[startOne++] : intArr[startTwo++];
                }
                while (startOne < endOne) {
                    outIntArr[low++] = intArr[startOne++];
                }
                while (startTwo < endTwo) {
                    outIntArr[low++] = intArr[startTwo++];
                }
            }
            int[] temp = intArr;
            intArr = outIntArr;
            outIntArr = temp;
//
//            System.out.println("intArr = ");
//            for (int i : intArr) {
//                System.out.print(i + ",");
//            }
//            System.out.println();
        }
        return intArr;
    }
}
