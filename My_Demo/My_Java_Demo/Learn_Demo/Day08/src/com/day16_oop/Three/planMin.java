package com.day16_oop.Three;

public class planMin {
    public static void main(String[] args) {
        Person pr = new Person("张三",20);
        //Fitness fitness = new Fitness();
        Plan p = new Plan("拉拉胫骨", "平板撑");

        pr.startExercise(p);
        //p.pringPlan();
    }
}
