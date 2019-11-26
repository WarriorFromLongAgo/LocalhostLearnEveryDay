package com.day25_she_ji_mo_shi.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) throws InterruptedException {
//        每个线程在执行的时候都会先休眠2秒，
//        但是每1秒向线程池添加新的任务，
//        添加第一个任务的时候先新增一个线程
//        添加第二个任务的时候，又新增一个线程
//        添加第三个任务的时候，又新增一个线程

//        但是添加第四个的时候，第一个线程已经空闲，然后第一个执行第四个线程

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 30; i++) {
            final int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " = " + finalI);
                }
            };
            cachedThreadPool.execute(runnable);
            Thread.sleep(1000);
        }
    }
}
