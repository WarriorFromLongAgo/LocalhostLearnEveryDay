package com.day25_she_ji_mo_shi.executorservice;

public class ThreadTest1 {
    // T1、T2、T3三个线程顺序执行
    public static void main(String[] args) {
        Thread t1 = new Thread(new Work());
        t1.setName("t1");
        Thread t2 = new Thread(new Work(t1));
        t2.setName("t2");
        Thread t3 = new Thread(new Work(t2));
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();

    }

    static class Work implements Runnable {
        private Thread beforeThread;

        public Work() {

        }

        public Work(Thread beforeThread) {
            this.beforeThread = beforeThread;
        }

        @Override
        public void run() {
            if (beforeThread != null) {
                try {
                    beforeThread.join();

                    for (int i = 0; i < 100; i++) {
                        System.out.println("thread start:  " + Thread.currentThread().getName());
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.currentThread().join();
                    for (int i = 0; i < 100; i++) {
                        System.out.println("thread start:  " + Thread.currentThread().getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}