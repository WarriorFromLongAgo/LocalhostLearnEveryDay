package com.day11_thread_runnable_mai_piao.thread_runnable_mai_piao.thread_runnable_mai_piao.selltickets;

public class SellTickets implements Runnable {
    private int tickets = 100;

    //创建锁对象
    //把这个关键的锁对象定义到run()方法(独立于线程之外)，造成同一把锁
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //synchronized 为 上锁
            synchronized (obj){
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                            + "正在出售第" + (tickets--) + "张票");
                }if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                            + "正在出售第" + (tickets--) + "张票");
                }
            }
        }
    }
}