package com.day25_she_ji_mo_shi.deadlock;

@SuppressWarnings("all")
public class DeadLock {
    public static void main(String[] args) {
        Chopsticks chopsticks = new Chopsticks();

        Thread oneThread = new Thread(chopsticks);
        oneThread.setName("一号筷子");
        Thread twoThread = new Thread(chopsticks);
        twoThread.setName("二号筷子");

        oneThread.start();
        twoThread.start();
    }
}
