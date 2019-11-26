package com.day25_she_ji_mo_shi.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//  线程一组组的使用，带来性能的提升
//

public class new1ScheduledExecutorService {
    public static void main(String[] args) throws InterruptedException {
        method2();
    }


    //  第一个1是延迟启动当前任务，第二个1是演示启动下一个任务
    private static void method2() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
//                for (int i = 0; i < 30; i++) {
                    System.out.println(Thread.currentThread().getName());
//                }
            }
        };
        scheduledExecutorService.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
    }

    private static void method1() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int index = i;
            //  command
            scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " = " + index);
                }
            }, 3, 10, TimeUnit.SECONDS);
            //  使用的是一秒的单位，3秒后开始执行，每两秒刷新一次
        }
    }
}
