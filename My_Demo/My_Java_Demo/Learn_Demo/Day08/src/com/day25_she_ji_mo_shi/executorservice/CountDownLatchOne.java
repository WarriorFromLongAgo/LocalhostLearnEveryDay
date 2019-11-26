package com.day25_she_ji_mo_shi.executorservice;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchOne {

    public static void main(String[] args) {
        System.out.println("准备开始执行任务");
        CountDownLatch countDownLatch = new CountDownLatch(5);
        WorkA1 workA1 = new WorkA1(countDownLatch);
        WorkA2 workA2 = new WorkA2(countDownLatch);
        workA1.start();
        workA2.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("执行完成了。");
    }
}

class WorkA1 extends Thread {
    private CountDownLatch countDownLatch;

    public WorkA1(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("WorkA1 开始执行");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
        System.out.println("WorkA1 结束执行");
    }
}

class WorkA2 extends Thread {
    private CountDownLatch countDownLatch;

    public WorkA2(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("WorkA2 开始执行");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
        System.out.println("WorkA2 结束执行");
    }
}