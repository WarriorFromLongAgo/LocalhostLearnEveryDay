package com.day24_Thread24.runthread;

public class AnimalThread {
    public static void main(String[] args) {
        Animal cat = new Animal("Cat");
        Animal dog = new Animal("Dog");
        Animal fish = new Animal("Fish");

        cat.start();
        dog.start();
        fish.start();
    }
}
