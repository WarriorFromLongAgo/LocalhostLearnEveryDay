package com.day25_she_ji_mo_shi.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceOne {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            int index = i;
            executorService.submit(() -> {

                System.out.println(Thread.currentThread().getName() + "x = " + index);
            });
        }
        executorService.shutdown();
    }
}
