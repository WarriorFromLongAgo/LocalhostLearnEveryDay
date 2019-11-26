package com.day16_oop.huoanimal;

public class Dog extends Animal implements Swim {
    @Override
    public void eat() {
        System.out.println(" 吃骨头 ");
    }

    @Override
    public void SmimWay() {
        System.out.println(" 狗刨 ");
    }
}
