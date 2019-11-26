package com.day08_bie_kan;

public class sum_0_100 {
    public static void main(String[] args) {
        //用来计数
        int count = 0;
        //求和
        int num = 0;
        //第一个数，最后一个数
        int left = 1;
        int right = 100;
        //中位数
        int middle = right / 2;
        //如果是奇数，就把中位数给middle
        if ((right & 1) != 0) {
            num = left + ((right - left) / 2);
        }

        System.out.println("dowhile题目 第一次 = " + num);
        do {
            num = left + right + num;
            left++;
            right--;
            count++;
        } while (count < middle);

        System.out.println("dowhile题目 最后一次" + num);
    }
}
