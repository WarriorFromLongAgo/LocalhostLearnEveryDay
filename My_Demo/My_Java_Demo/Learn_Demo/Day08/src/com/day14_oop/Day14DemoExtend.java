package com.day14_oop;

public class Day14DemoExtend extends day14Demo {
    public final static String ADDRESS = "湖北";
    public int id;

    public Day14DemoExtend() {

    }

    public Day14DemoExtend(int id) {
        this.id = id;
    }

    @Override
    public void print() {
        System.out.println("子类的 print");
    }
//    @Override
//    public void eat(){
//
//    }
}
