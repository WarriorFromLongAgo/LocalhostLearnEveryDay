package com.day25_she_ji_mo_shi.productconsumer;

public class Waiter_Consumer implements Runnable {
    private MiddleWaiting middleWaiting;

    public Waiter_Consumer(MiddleWaiting middleWaiting) {
        this.middleWaiting = middleWaiting;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            synchronized (middleWaiting) {
                if (!middleWaiting.flag) {
                    try {
                        middleWaiting.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String StrmiddleWaiting = middleWaiting.getWaiting();
                System.out.println(" 服务员从中间端走了一个菜 " + StrmiddleWaiting);
                middleWaiting.flag = false;
                middleWaiting.notify();
            }
        }
    }
}
