package com.day24_Thread24;

import java.util.Base64;

public class thread1 {
    public static void main(String[] args) {
//        temp temp = new temp();
//        Thread thread1 = new Thread(temp);
//        thread1.setName("thread1");
//        Thread thread2 = new Thread(temp);
//        thread2.setName("thread2");
//
//        thread1.start();
//        thread2.start();

        String temp = "fejm";
        String string = Base64.getEncoder().encodeToString(temp.getBytes());
        System.out.println(string);
        byte[] decode = Base64.getDecoder().decode(string);
        System.out.println(new String(decode));
    }
}

class temp extends Thread {
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(Thread.currentThread().getName() + " 线程 " + i);
//        }
//    }
}
