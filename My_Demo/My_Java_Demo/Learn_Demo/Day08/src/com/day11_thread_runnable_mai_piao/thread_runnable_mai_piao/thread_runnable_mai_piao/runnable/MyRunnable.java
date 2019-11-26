package com.day11_thread_runnable_mai_piao.thread_runnable_mai_piao.thread_runnable_mai_piao.runnable;
//https://juejin.im/post/5d2fcc406fb9a07ed8427863


//实现接口方式的好处
//
//可以避免由于Java单继承带来的局限性
//
//适合多个相同程序的代码去处理同一个资源的情况，把线程同程序的代码，数据有效分离，较好的体现了面向对象的设计思想
//
//如何理解------可以避免由于Java单继承带来的局限性
//接口可以多实现implements，但是继承extends只能单继承) ，
// 它的父类也不想继承Thread因为不需要实现多线程

public class MyRunnable implements Runnable {
    public MyRunnable() {

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
