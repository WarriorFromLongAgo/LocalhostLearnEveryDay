package com.day25_she_ji_mo_shi.executorservice;

public class Thread6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new threahd());
        t1.setName("t1");
        Thread t2 = new Thread(new threahd());
        t2.setName("t2");
        Thread t3 = new Thread(new threahd());
        t3.setName("t3");
        t1.start();
        t1.join();
        t2.start();
        t2.join();

        t3.start();
    }
}

class threahd implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
