package com.day15_interence.day15Interface;

public class day15Cat extends Day15Animal implements day15InterfaceThree {
    public String name;

    public day15Cat() {
    }

    public day15Cat(String name) {
        System.out.println(i + this.name);
    }

    @Override
    public void run() {
        System.out.println("day15Cat = cat + " + this.name);
    }

    @Override
    public void dance() {

    }

    @Override
    public void eat(int tempInt) {
        System.out.println("day15Cat = eat = " + tempInt);
    }
}
