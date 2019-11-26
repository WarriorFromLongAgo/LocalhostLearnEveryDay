package com.day27_classLoader.classconstructor;

import java.lang.reflect.InvocationTargetException;

public class Constructor2 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<day27Student> day27StudentClass = day27Student.class;
        day27Student day27Student = day27StudentClass.getConstructor(Integer.class, String.class).newInstance(1, "1111");

        System.out.println(day27Student.getId());
        System.out.println(day27Student.getName());

        for (int i = 0; i < day27StudentClass.getConstructors().length; i++) {
            System.out.println(day27StudentClass.getConstructors()[i]);
        }
    }
}
