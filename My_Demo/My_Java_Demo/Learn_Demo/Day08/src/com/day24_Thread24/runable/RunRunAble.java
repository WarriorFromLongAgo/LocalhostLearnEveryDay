package com.day24_Thread24.runable;

public class RunRunAble implements Runnable {
    @Override
    public void run() {
        int i = 1;
        while (i <= 10) {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + " = " + i);
            i++;
        }
    }
}
