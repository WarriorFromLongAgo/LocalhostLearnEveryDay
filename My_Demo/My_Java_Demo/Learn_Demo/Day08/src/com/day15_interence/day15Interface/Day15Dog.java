package com.day15_interence.day15Interface;

public class Day15Dog extends Day15Animal implements day15InterfaceThree {
    public String name;

    public Day15Dog() {

    }

    public Day15Dog(String name) {
        System.out.println(i + this.name);
    }

    @Override
    public void eat(int tempInt) {
        System.out.println("Day15Dog = eat = " + tempInt);
    }

    @Override
    public void run() {
        System.out.println("Day15Dog = dog = " + this.name);
    }

    @Override
    public void dance() {

    }
}
