package com.day24_Thread24.salpiao;

public class salPiao {
    public static void main(String[] args) {
        Piao piao = new Piao();
        Thread thread = new Thread(piao);
        thread.setName("窗口1 ");
        Thread thread1 = new Thread(piao);
        thread1.setName("窗口2 ");
        Thread thread2 = new Thread(piao);
        thread2.setName("窗口3 ");

        thread.start();
        thread1.start();
        thread2.start();
    }
}
