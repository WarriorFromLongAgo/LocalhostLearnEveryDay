package com.day08_bie_kan;

public class GrammerOrgami {
    public static void main(String[] args) {
        int temp = 0;
        double num = 0.00001;
        while (num < 100) {
            num = num * 2;
            temp++;
        }
        System.out.println("折纸题目 = " + temp);
    }
}
