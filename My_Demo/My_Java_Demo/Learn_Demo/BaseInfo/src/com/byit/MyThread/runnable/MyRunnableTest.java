package com.byit.MyThread.runnable;

public class MyRunnableTest {
    public static void main(String[] args) {
        MyRunnable myRunnableOne = new MyRunnable();
        //创建Thread类的对象，并把C步骤的对象作为构造参数传递
//        Thread t1 = new Thread(myRunnableOne);
//        Thread t2 = new Thread(myRunnableOne);
//        //下面具体讲解如何设置线程对象名称
//        //User2:先跑到 99
//        //Thread-1 然后另一个跑到 99
//        t1.setName("User1");
//        t1.setName("User2");

        //先跑完1，再跑2
        //  会乱序
        Thread t1 = new Thread(myRunnableOne,"User1");
        Thread t2 = new Thread(myRunnableOne,"User2");
        t1.start();
        t2.start();

    }
}
