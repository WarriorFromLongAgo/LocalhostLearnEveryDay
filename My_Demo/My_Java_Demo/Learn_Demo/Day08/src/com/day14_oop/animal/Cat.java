package com.day14_oop.animal;

public class Cat extends Animal {
    public final String cat = "cat";

    public Cat() {
        super();
    }

//    public Cat(int eyes) {
//        this.eyes = eyes;
//    }

    @Override
    public void eat() {

    System.out.println(cat + " 用嘴巴吃喜欢的东西 ");
        System.out.println(super.eyes);
        System.out.println(head);
        System.out.println(cat + " 喜欢 吃鱼");
    }

    @Override
    public void shouming() {
        System.out.println(cat + " 的寿命在7-10年 ");
    }

    public void paTree() {
        System.out.println(cat + " 会爬树 ");
    }

}
