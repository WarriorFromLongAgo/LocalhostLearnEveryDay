package com.day25_she_ji_mo_shi.deadlock;

public class Chopsticks implements Runnable {
    private final String oneChops = "一号筷子";
    private final String twoChops = "二号筷子";

    @Override
    public void run() {
        if ("一号筷子".equals(Thread.currentThread().getName())) {
            oneChopsticks();
        }
        if ("二号筷子".equals(Thread.currentThread().getName())) {
            twoChopsticks();
        }
    }

    private void oneChopsticks() {
        synchronized (oneChops) {
            System.out.println("一号 向 二号借筷子，，并且等待二号给他筷子");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (twoChops) {
                System.out.println(" 一号得到了二号的筷子，开始了吃饭 ");
            }
        }
    }

    private void twoChopsticks() {
        synchronized (twoChops) {
            System.out.println(" 二号向一号借筷子，并且等待一号给他筷子 ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (oneChops) {
                System.out.println("二号得到了一号的筷子，开始了吃饭");
            }
        }
    }
}
