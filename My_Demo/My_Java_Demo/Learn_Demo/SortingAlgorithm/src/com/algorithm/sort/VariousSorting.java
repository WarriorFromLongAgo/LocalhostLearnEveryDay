package com.algorithm.sort;

import com.algorithm.sort.binarysearch.BinarySearch;
import com.algorithm.sort.insertsort.InsertSort;

import java.time.temporal.Temporal;
import java.util.ArrayList;

/**
 * @Author:
 * @Project:
 * @Time:
 * @version:
 * @修改原因:
 */
public class VariousSorting {
    public static void main(String[] args) {
//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.bubbleSolution();
//
//        BinarySearch binarySearch = new BinarySearch();
//        binarySearch.binarySolution();

//        InsertSort insertSort = new InsertSort();
//        insertSort.insertSolution();
//
//        SelectSort selectSort = new SelectSort();
//        selectSort.selectSolution();
//
//        MergeSortSort mergeSort = new MergeSortSort();
//        mergeSort.MergeSolution();
    }
}

//class BubbleSort {
//    public void bubbleSolution() {
//        int[] tempInt = new int[]{55, 51, 90, 11, 20, 5, 1, 85};
//        int[] outputIntArr = this.bubbleSort(tempInt);
//        System.out.print("bubbleSort = ");
//        for (int i : outputIntArr) {
//            System.out.print(i + "，");
//        }
//        System.out.println();
//        System.out.println("=========================================");
//
//    }
//
//    /**
//     * @Author: feijm
//     * @Project: bubbleSort 冒泡排序
//     * @Time: 2019年7月15日10:15:39
//     * @version: 1.0
//     * @修改原因: 无
//     * @特点：多次移动元素，多次比较元素
//     * @优点：比较起来比较简单，空间复杂度低， 稳定的排序算法
//     * @缺点：时间复杂度很高， 时间复杂度：On^2
//     * 空间复杂度：On^1
//     * <p>
//     * 比较相邻的元素，如果当前的元素大于后面的元素，则进行交换。否则不进行交换。
//     * 6 3 5 7 0 6-3
//     * 3 6 5 7 0 6-5
//     * 3 5 6 7 0 6-7
//     * 3 5 6 7 0 7-0
//     * 3 5 6 0 7 3-5
//     * 3 5 6 0 7 5-6
//     * 3 5 6 0 7 6-0
//     * 3 5 0 6 7 6-7
//     * 3 5 0 6 7 3-5
//     * 3 0 5 6 7 5-0
//     * 0 3 5 6 7 3-0
//     */
//    private int[] bubbleSort(int[] inputIntArr) {
//        if (inputIntArr.length < 2) {
//            return inputIntArr;
//        }
//        int inputIntArrLength = inputIntArr.length;
//        int num = 0;
//        for (int i = 0; i < inputIntArrLength - 1; i++) {
//            for (int j = 0; j < inputIntArrLength - 1 - i; j++) {
//                num++;
//                if (inputIntArr[j] > inputIntArr[j + 1]) {
//                    int tempInt = inputIntArr[j + 1];
//                    inputIntArr[j + 1] = inputIntArr[j];
//                    inputIntArr[j] = tempInt;
//                }
//            }
//        }
//        System.out.println("执行次数 num = " + num);
//        //  28次
//        return inputIntArr;
//    }

    /**
     * @Author: feijm
     * @Project: bubbleSort 冒泡排序
     * @Time: 2019年7月15日10:25:39
     * @version: 1.1
     * @修改原因: 冒泡排序算法优化，从1.0修改
     * @特点：多次移动元素，多次比较元素
     * @优点：比较起来比较简单，空间复杂度低，是稳定的排序算法
     * @缺点：时间复杂度很高，
     */
//    private int[] bubbleSort(int[] inputIntArr) {
//        int inputIntArrLength = inputIntArr.length;
//        int num = 0;
//        for (int i = 0; i < inputIntArrLength; i++) {
//            boolean isSort = true;
//
//            for (int j = 0; j < inputIntArrLength - 1 - i; j++) {
//                num++;
//                if (inputIntArr[j] > inputIntArr[j + 1]) {
//                    int tempInt = inputIntArr[j];
//                    inputIntArr[j] = inputIntArr[j + 1];
//                    inputIntArr[j + 1] = tempInt;
//                    isSort = false;
//                }
//            }
//            if(isSort){
//                break;
//            }
//        }
//        //执行次数 28
//        System.out.println("执行次数 num = " + num);
//        return inputIntArr;
//    }


//}

//class BinarySearch {
//    public void binarySolution() {
//        int[] tempIntArr = new int[]{1, 3, 4, 5, 10, 30, 45, 55, 67, 81, 89, 92, 101};
//        int key = 92;
//        int arrIndex = this.binarySearch(tempIntArr, key);
//        System.out.println("ArrIndex = " + arrIndex);
//        System.out.println("=========================================");
//
//    }
//
//    /**
//     * @Author: feijm
//     * @Project: BinarySearch 二分查找运算
//     * @Time: 2019年7月14日20:46:01
//     * @version: 1.0
//     * @修改原因: 无
//     * middle = left+(right-left)/2
//     * 如果大于middle
//     * 如果小于middle
//     */
//    private int binarySearch(int[] inputIntArr, int key) {
//        int left = 0;
//        int right = inputIntArr.length - 1;
//        while (right >= left) {
//            //
//            int middle = left + ((right - left) / 2);
//            if (key > inputIntArr[middle]) {
//                left = middle + 1;
//            } else if (inputIntArr[middle] > key) {
//                right = middle - 1;
//            } else {
//                return middle;
//            }
//        }
//        return -1;
//    }
//}

//class InsertSort implements Comparator<Object> {
//class InsertSort {
//    public void insertSolution() {
//        int[] tempIntArr = new int[]{55, 51, 90, 11, 20, 5, 1, 85};
//        ArrayList<Integer> tempInt = new ArrayList<Integer>();
//        //100    5
//        //1000   50
//        //10000  800-900
//        for (int i = 100; i > 0; i--) {
//            tempInt.add(i);
//        }
////        for (int i = 0; i < tempIntArr.length; i++) {
////            tempInt.add(tempIntArr[i]);
////        }
//        long startTime = System.currentTimeMillis();
//        ArrayList<Integer> outputIntArr = this.insertSort(tempInt);
//        long endTime = System.currentTimeMillis();
//        long time = endTime - startTime;
//        System.out.println("time = " + time + "ms");
//        for (int x : outputIntArr) {
//            System.out.print(x + "，");
//        }
//        System.out.println();
//        System.out.println("=======================================");
//    }
//
////    @Override
////    public int compare(Object o1, Object o2) {
////        int TempO1 = (int) o1;
////        int TempO2 = (int) o2;
////
////        if (TempO1 > TempO2) {
////            return 1;
////        } else if (TempO1 < TempO2) {
////            return -1;
////        }
////        else {
////            return 0;
////        }
////    }
//
//    /**
//     * @Author: feijm
//     * @Project: insertSort
//     * @Time: 2019年7月15日15:49:23
//     * @version: 1.0
//     * @修改原因: 无
//     * <p>
//     * 空间复杂度：On用于存放排序的数组
//     * 时间复杂度：On^2
//     *
//     * <p>
//     * 建立一个排序完成的区间，将未排序的元素，有序的放入已排序的区域，
//     * 如果发现一个很少的元素，，则进行前移操作，，发现排序完成时，进行break
//     * | 6 3 5 7 0
//     * 6            | 3 5 7 0
//     * 6 3          | 5 7 0
//     * 3 6          | 5 7 0
//     * 3 6 5        | 7 0
//     * 3 5 6        | 7 0
//     * 3 5 6 7      | 0
//     * 3 5 6 7 0
//     * 3 5 6 0 7
//     * 3 5 0 6 7
//     * 3 0 5 6 7
//     * 0 3 5 6 7
//     */
//    private ArrayList<Integer> insertSort(ArrayList<Integer> inputIntArr) {
//        if (inputIntArr.size() < 2) {
//            return inputIntArr;
//        }
//        int num = 0;
//
//        for (int i = 1; i < inputIntArr.size(); i++) {
//            for (int j = i; j > 0; j--) {
//                num++;
//                if (inputIntArr.get(j - 1) > inputIntArr.get(j)) {
//                    int tempInt = inputIntArr.get(j);
//                    inputIntArr.set(j, inputIntArr.get(j - 1));
//                    inputIntArr.set(j - 1, tempInt);
//                } else {
//                    break;
//                }
//            }
//            //System.out.print("insertSort = ");
//
////            for (int x : inputIntArr) {
////                System.out.print(x + "，");
////            }
////            System.out.println();
//        }
//        //System.out.println("运行了 = " + num);
//        return inputIntArr;
//    }
//}

//class SelectSort {
//    public void selectSolution() {
//        int[] tempInt = new int[]{55, 51, 90, 11, 20, 5, 1, 85};
//        int[] outputIntArr = this.selectSort(tempInt);
//        System.out.println("原来的数组 = {55, 51, 90, 11, 20, 5, 1, 85};");
//        System.out.print("selectSort = ");
//        for (int i : outputIntArr) {
//            System.out.print(i + "，");
//        }
//        System.out.println();
//        System.out.println("=======================================");
//    }
//
//    /**
//     * @Author:
//     * @Project:
//     * @Time:
//     * @version:
//     * @修改原因: 第一位 和 后面的进行对比，
//     * 每一次运行都要将一个剩余待分配的最小值，放在数组的开头。
//     * 6 3 5 7 0   6-3比较
//     * 3 6 5 7 0   3-5比较
//     * 3 6 5 7 0   3-7比较
//     * 0 6 5 7 3   3-0比较
//     * 0 6 5 7 3   6-5
//     * 0 5 6 7 3   5-7
//     * 0 5 6 7 3   5-3
//     * 0 3 6 7 5   6-7
//     * 0 3 6 7 5   6-5
//     * 0 3 5 7 6   7-6
//     * 0 3 5 6 7
//     * 数组的长度就是时间复杂度
//     * 时间复杂度：O(n^2) 空间复杂度O(n)
//     */
//    private int[] selectSort(int[] inputIntArr) {
//        if (inputIntArr.length < 2) {
//            return inputIntArr;
//        }
//        int num = 0;
//
//        for (int i = 0; i < inputIntArr.length - 1; i++) {
//            for (int j = i + 1; j < inputIntArr.length; j++) {
//                num++;
//                if (inputIntArr[i] > inputIntArr[j]) {
//                    int temp = inputIntArr[i];
//                    inputIntArr[i] = inputIntArr[j];
//                    inputIntArr[j] = temp;
//                }
//            }
//        }
//        System.out.println("运行了 = " + num);
//        return inputIntArr;
//    }
//}

//class MergeSortSort {
//    public void MergeSolution() {
//        ArrayList<Integer> tempIntArrList = new ArrayList<Integer>();
//        int[] tempIntArr = new int[]{55, 51, 90, 11, 20, 5, 1, 85};
////        for (int i = 100; i > 0; i--) {
////            tempIntArrList.add(i);
////        }
////        for (int i = 0; i < tempIntArr.length; i++) {
////            tempIntArr.(tempIntArr[i]);
////        }
//        long startTime = System.currentTimeMillis();
//        int[] outputIntArr = this.mergeSort(tempIntArr);
//        //this.mergeSort(tempIntArr);
//        //ArrayList<Integer> outputIntArr = this.mergeSort(tempIntArr);
//
//        long endTime = System.currentTimeMillis();
//        long time = endTime - startTime;
//        System.out.println("time = " + time + "ms");
//
//        System.out.print("outPutIntArr = ");
//        for (int x : outputIntArr) {
//            System.out.print(x + "，");
//        }
//        System.out.println();
//
//        System.out.println("=======================================");
//    }
//
//    private int[] mergeSort(int[] inputIntArr) {
//        if (inputIntArr.length < 2) {
//            //return;
//            return inputIntArr;
//        }
//        int left = 0;
//        int block;
//        int right = inputIntArr.length;
//        int[] outPutIntArr = new int[inputIntArr.length];
//        //ArrayList<Integer> outPutIntArrList = new ArrayList<Integer>();
//        for (block = 1; block < right; block *= 2) {
//            for (left = 0; left < right; left += 2 * block) {
//                int low = left;
//                int middle = (left + block) < right ? (left + block) : right;
//                int high = (left + 2 * block) < right ? (left + 2 * block) : right;
//
//                int startOne = low;
//                int endOne = middle;
//
//                int startTwo = middle;
//                int endTwo = high;
//
//                while (startOne < endOne && startTwo < endTwo) {
//                    outPutIntArr[low++] = (outPutIntArr[startOne++] < outPutIntArr[startTwo]) ? outPutIntArr[startOne++] : outPutIntArr[startTwo++];
//                }
//                while (startOne < endOne) {
//                    outPutIntArr[low++] = inputIntArr[startOne++];
//                }
//                while (startTwo < endTwo) {
//                    outPutIntArr[low++] = inputIntArr[startTwo++];
//                }
//            }
//            int[] tempArr = inputIntArr;
//            inputIntArr = outPutIntArr;
//            outPutIntArr = tempArr;
//        }
//
////        System.out.print("tempArr = ");
////        for (int x : tempArr) {
////            System.out.print(x + "，");
////        }
////        System.out.print("inputIntArr = ");
////        for (int x : inputIntArr) {
////            System.out.print(x + "，");
////        }
////        System.out.print("outPutIntArr = ");
////        for (int x : outPutIntArr) {
////            System.out.print(x + "，");
////        }
////        System.out.println();
//
//
//        return Temporal;
//    }
//}




