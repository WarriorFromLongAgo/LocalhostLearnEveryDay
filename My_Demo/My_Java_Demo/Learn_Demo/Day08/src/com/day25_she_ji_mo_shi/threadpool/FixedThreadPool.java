package com.day25_she_ji_mo_shi.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int j = 0; j < 30; j++) {
            int index = j;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        System.out.println("num = " + index);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    System.out.println();
                }
            };
            fixedThreadPool.execute(runnable);
        }

        //  调度线程池
//        ScheduledExecutorService;
        //  普通的执行线程池
//        ExecutorService;

//        Executors
    }

}
