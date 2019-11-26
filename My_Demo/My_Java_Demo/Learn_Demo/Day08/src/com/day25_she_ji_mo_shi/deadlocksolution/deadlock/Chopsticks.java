package com.day25_she_ji_mo_shi.deadlocksolution.deadlock;

public class Chopsticks implements Runnable {
    private String oneChops = "一号筷子";
    private String twoChops = "二号筷子";

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("一号筷子")) {
            OneChopsticks();
        }
        if (Thread.currentThread().getName().equals("二号筷子")) {
            TwoChopsticks();
        }
    }

    public void OneChopsticks() {
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

    public void TwoChopsticks() {
        synchronized (oneChops) {
            System.out.println(" 二号向一号借筷子，并且等待一号给他筷子 ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (twoChops) {
                System.out.println("二号得到了一号的筷子，开始了吃饭");
            }
        }
    }
}
