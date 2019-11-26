package com.day14_oop;

public class day14Demo {
    private String name;
    private int age;
    public int id;

    public day14Demo() {

    }

    public day14Demo(int id) {
        this.id = id;
    }

    public day14Demo(String name, int age) {
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

    public void print(){
        System.out.println("父类的 print");
    }
    public final void eat(){
        System.out.println(" 父类的 eat ");
    }

}
