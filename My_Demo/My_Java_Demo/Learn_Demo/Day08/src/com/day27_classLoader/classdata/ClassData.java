package com.day27_classLoader.classdata;

public class ClassData {
    public static void main(String[] args) throws ClassNotFoundException {
        Class day27StudentClass = ClassData.class;

        ClassData classData = new ClassData();
        Class aClass = classData.getClass();

        Class aClass1 = Class.forName("com.day27_classLoader.classdata.ClassData");

        System.out.println(day27StudentClass);
        System.out.println(aClass);
        System.out.println(aClass1);

        System.out.println(day27StudentClass == aClass);
        System.out.println(aClass == aClass1);
    }
}
