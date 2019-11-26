package com.day16_oop.huoanimal;

public class Sheep extends Animal implements Swim {
    @Override
    public void eat() {
        System.out.println(" 吃虫子 ");
    }

    @Override
    public void SmimWay() {
        System.out.println(" 蛙泳 ");
    }
}
