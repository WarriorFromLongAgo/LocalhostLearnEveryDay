package com.day09_ru_men3;

//发现元素
public class finddata {
    public static void main(String[] args) {
        int[] num = {3221, 6, 3, 0, 43, 312, 7, 32, 322};
        int count = 0;
        //返回查找元素的下表
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            count++;

            if (num[i] == 0) {
                index = i;
                break;
            }
        }
        System.out.println("0元素的下标索引 index = " + index);
        System.out.println("for循环运行了 count = " + count);
    }
}
