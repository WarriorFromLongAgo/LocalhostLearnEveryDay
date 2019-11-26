package com.day25_she_ji_mo_shi.executorservice;

public class ABC {
    public static void main(String[] args) {
        Thread one = new Thread(new work());
        one.setName(" one ");
        Thread two = new Thread(new work());
        two.setName(" two ");
        Thread three = new Thread(new work(one, two));
        three.setName(" three ");

        one.start();
        two.start();
        three.start();
    }
}

class work implements Runnable {
    private Thread oneThread;
    private Thread twoThread;

    public work() {

    }

    public work(Thread oneThread, Thread twoThread) {
        this.oneThread = oneThread;
        this.twoThread = twoThread;
    }

    @Override
    public void run() {
        if (oneThread != null && twoThread != null) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " = " + i);
            }
        } else {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " = " + i);
            }
        }
    }
}
