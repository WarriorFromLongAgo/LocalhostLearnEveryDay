package com.day25_she_ji_mo_shi.executorservice;

public class Thread5 {
    public static void main(String[] args) throws Exception {
        Thread myThread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(getName() + "   i为:" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread myThread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "   i为:" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        //开始myThread1，myThread2线程
        myThread1.start();
        myThread2.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "  i为:" + i);
            Thread.sleep(100);
            // 主线程执行到i=50后阻塞，等待myThread1，myThread2执行完后再执行
            if (i == 50) {
                myThread1.join();
                myThread2.join();
            }
        }
    }
}
