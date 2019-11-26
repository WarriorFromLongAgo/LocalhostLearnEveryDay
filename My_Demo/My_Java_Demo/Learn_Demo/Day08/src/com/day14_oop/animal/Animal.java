package com.day14_oop.animal;

public abstract class Animal {
    public final int head = 1;
    public int erduo;
    public int eyes = 2;
    public final int zuiba = 1;
    public String yachi;
    public int tui;
    public int weiba = 1;
    public String hobby;
    public int age;
    public int shouming;
    public String puruAnimal;
    public int tiwenhengding;

    public Animal() {

    }

    public Animal(int eyes) {
        this.eyes = eyes;
    }

    public void shouming() {
        System.out.println(" 根据物种的不同，寿命不同 ");
    }

    public void eat() {
        System.out.println(" 用嘴巴吃喜欢的东西 ");

    }

    public void run() {
        System.out.println(" 正常的跑步 ");
    }

}
