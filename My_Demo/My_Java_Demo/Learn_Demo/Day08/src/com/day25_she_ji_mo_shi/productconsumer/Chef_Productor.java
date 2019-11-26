package com.day25_she_ji_mo_shi.productconsumer;

public class Chef_Productor implements Runnable {
    private MiddleWaiting middleWaiting;



    public Chef_Productor(MiddleWaiting middleWaiting) {
        this.middleWaiting = middleWaiting;
    }

    @Override
    public void run() {
        int count = 1;
        while (true) {

            synchronized (middleWaiting) {
                if (middleWaiting.flag) {
                    try {
                        System.out.println("middleWaiting.wait(1000000000); 执行");
                        middleWaiting.wait(10000);
                        System.out.println("middleWaiting.wait(1000000000); 结束执行");

                        middleWaiting.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String products = " 啤酒鸭" + count++;
                middleWaiting.setWaiting(products);
                System.out.println(" 生产者把产品放在了 等待区 ");
                middleWaiting.flag = true;
                middleWaiting.notify();
            }
        }
    }
}
