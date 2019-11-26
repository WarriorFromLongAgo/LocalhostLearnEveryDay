package com.day08_bie_kan;

public class GrammerWhile {
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
        //如果是奇数，就把中位数给num
        if ((right & 1) != 0) {
            num = left + ((right - left) / 2);
        }

        System.out.println("while题目 第一次 = " + num);
        while (count < middle) {
            //当最大值不是100时，处理int的溢出问题
            if (Integer.MAX_VALUE - num - right < left) {
                num = Integer.MAX_VALUE;
                break;
            }
            num = num + left + right;
            left++;
            right--;
            count++;
        }
        System.out.println("while题目 最后一次" + num);
    }
}
