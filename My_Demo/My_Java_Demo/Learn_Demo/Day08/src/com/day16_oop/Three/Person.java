package com.day16_oop.Three;

public class Person extends Fitness {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void startExercise(Fitness fitness) {
        System.out.println(this.name + "开始锻炼 ");
        fitnessPlan(new Plan());
    }
}
