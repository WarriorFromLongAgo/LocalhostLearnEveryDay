package com.byit.MyThread.ThreadOne;

//https://juejin.im/post/5d2fcc406fb9a07ed8427863
//方式1 继承Thread类

public class ThreadOne {
    public static void main(String[] args) {
        myThread myThread1 = new myThread();
        //启动线程，run()相当于普通方法的调用，单线程效果
        //Thread-0: 0 - 100
        myThread1.run();

        //Thread-0:先启动到99
        //然后Thread-1: 和 Thread-2:跳转交换增加
        //首先启动了线程，然后再由jvm调用该线程的run()方法，多线程效果
//        myThread1.start();

        //两个线程演示，多线程效果需要创建多个对象而不是一个对象多次调用start()方法
//        myThread myThreadOne = new myThread();
//        myThread myThreadTwo = new myThread();
//
//        myThreadOne.start();
//        myThreadTwo.start();

    }
}

