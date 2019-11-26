package com.day25_she_ji_mo_shi.executorservice;

public class Thread4 {
    public static void main(String[] args) {
        Thread4 p = new Thread4();
        A a = p.new A();
        B b = p.new B();
        new Thread(a).start();
        new Thread(b).start();
    }


    public synchronized void print(String str, int i) {
        notify();
        System.out.println(str + i);
        if (i >= 10) {
            System.exit(1);
        }
        try {
            wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    class A implements Runnable {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            for (int i = 1; i < 100; i += 2) {
                print("A", i);
            }
        }
    }

    class B implements Runnable {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            for (int i = 2; i <= 100; i += 2) {
                print("B", i);
            }
        }
    }
}








