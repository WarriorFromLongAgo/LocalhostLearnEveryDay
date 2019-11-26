package com.day24_Thread24.salpiao;

public class Piao implements Runnable {
    private int sizee = 100;


    @Override
    public void run() {
        while (sizee >= 0) {

            synchronized (this) {
//                try {
////                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                if (sizee <= 0) {
                    break;
                }
                --sizee;
                System.out.println(Thread.currentThread().getName() + " 票正在卖，还剩余 = " + sizee);
            }
        }
    }
}
