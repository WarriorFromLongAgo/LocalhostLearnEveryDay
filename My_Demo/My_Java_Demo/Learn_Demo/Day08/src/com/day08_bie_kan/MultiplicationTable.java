package com.day08_bie_kan;

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("九九乘法表");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                int tempInt = i * j;
                System.out.print(i + "*" + j + "=" + tempInt + "\t");
            }
            System.out.println();
        }
    }
}
