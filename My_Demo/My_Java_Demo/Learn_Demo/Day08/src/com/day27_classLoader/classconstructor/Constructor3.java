package com.day27_classLoader.classconstructor;

import java.lang.reflect.InvocationTargetException;

public class Constructor3 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        day27Student tempDay27Student = new day27Student();
        Class<? extends com.day27_classLoader.classconstructor.day27Student> aClass = tempDay27Student.getClass();
//        com.day27_classLoader.classconstructor.Day27Student Day27Student = aClass.getConstructor().newInstance();
        com.day27_classLoader.classconstructor.day27Student day27Student = aClass.getConstructor().newInstance(1, "1111");

//        Day27Student.setId(1);
//        Day27Student.setName("1111");

        System.out.println(day27Student.getId());
        System.out.println(day27Student.getName());
    }
}
