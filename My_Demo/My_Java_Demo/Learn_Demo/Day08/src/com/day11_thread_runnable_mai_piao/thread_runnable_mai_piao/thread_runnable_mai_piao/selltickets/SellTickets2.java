package com.day11_thread_runnable_mai_piao.thread_runnable_mai_piao.thread_runnable_mai_piao.selltickets;
//Java使用的是抢占式调度模型
//A：如果消费者先抢到了CPU的执行权，它就会去消费数据，但是现在的数据是默认值，
// 如果没有意义，应该等数据有意义再消费。就好比买家进了店铺早点却还没有做出来，
// 只能等早点做出来了再消费
//B：如果生产者先抢到CPU的执行权，它就回去生产数据，但是，当它产生完数据后，
// 还继续拥有执行权，它还能继续产生数据，这是不合理的，你应该等待消费者将数据消费掉，
// 再进行生产。 这又好比，店铺不能无止境的做早点，卖一些，再做，避免亏本
//
//梳理思路：
//A：生产者 —— 先看是否有数据，有就等待，没有就生产，生产完之后通知消费者来消费数据
//B：消费者 —— 先看是否有数据，有就消费，没有就等待，通知生产者生产数据

//等待
//wait()
//唤醒单个线程
// notify()
//唤醒所有线程
// notifyAll()

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTickets2 implements Runnable {

    private int tickets = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //void lock() 加锁
                lock.lock();

                //;
                if (tickets > 0) {
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
                }
            } finally {
                //void unlock() 释放锁
                lock.unlock();
            }
        }
    }
}
