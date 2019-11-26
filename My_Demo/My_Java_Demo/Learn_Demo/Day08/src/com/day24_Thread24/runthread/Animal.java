package com.day24_Thread24.runthread;

public class Animal extends Thread {
    private String Name11;

    public Animal(String name11) {
        this.Name11 = name11;
    }

    @Override
    public void run() {
        int i = 1;
        while (i <= 10) {
            System.out.println(" Animal =  " + Name11 + " = " + i);
            i++;
        }
    }
}
