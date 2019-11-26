package com.byit.MyThread.ThreadOne;

public class myThread extends Thread {
    public myThread() {

    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ": " + i);
        }
    }
}
