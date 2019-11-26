package com.byit.MultiThreading;

public class MultiThread {
    private static int count = 0;

    public static void main(String[] args) {
        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count++;
                System.out.println("One = " + count);
            }
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count++;
                System.out.println("Two = " + count);
            }
        });
        threadOne.start();
        threadTwo.start();
    }
}

