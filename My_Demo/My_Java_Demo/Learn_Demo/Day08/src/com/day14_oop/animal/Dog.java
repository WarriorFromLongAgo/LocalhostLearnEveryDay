package com.day14_oop.animal;

public class Dog extends Animal {
    public final String dog = "dog";


    public Dog() {

    }

    @Override
    public void eat() {
        System.out.println(dog + " 用嘴巴吃喜欢的东西 ");

        System.out.println(dog + "  喜欢 吃骨头 ");
    }

    @Override
    public void shouming() {
        System.out.println(dog + " 的在7-10年 ");
    }

    public void zhongcheng() {
        System.out.println(dog + " 非常忠诚 ");
    }
}
