package com.byit.MyThread.selltickets;

public class SellTicketsTest {
    public static void main(String[] args) {
        //创建资源对象
        SellTickets2 st = new SellTickets2();

        //创建线程对象
        Thread t1 = new Thread(st, "窗口1");
        Thread t2 = new Thread(st, "窗口2");
        Thread t3 = new Thread(st, "窗口3");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
