package com.day27_classLoader.classfeild;

import java.lang.reflect.Field;

public class ClassFeild {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Day27Student day27Student = new Day27Student(1, "1111");
        Class<Day27Student> day27StudentClass = Day27Student.class;

        Field[] fields = day27StudentClass.getFields();
        for (Field field : fields) {
//            public java.lang.Integer com.day27_classLoader.classfeild.Day27Student.age
            System.out.println(field);
        }

        for (Field declaredField : day27StudentClass.getDeclaredFields()) {
//            public java.lang.Integer com.day27_classLoader.classfeild.Day27Student.age
//            private java.lang.Integer com.day27_classLoader.classfeild.Day27Student.id
//            private java.lang.String com.day27_classLoader.classfeild.Day27Student.name
//            public java.lang.Integer com.day27_classLoader.classfeild.Day27Student.age
//            private static java.lang.String com.day27_classLoader.classfeild.Day27Student.className
            System.out.println(declaredField);
        }
        Field className = day27StudentClass.getDeclaredField("className");
        className.setAccessible(true);
        className.set(null, "java101");
        System.out.println(className.get(className));

        Field id = day27StudentClass.getDeclaredField("id");
        id.setAccessible(true);
        id.set(day27Student, 10001);
//        System.out.println();

        Field name = day27StudentClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(day27Student, "abcd");
//        System.out.println(name.get(name));

        Field age = day27StudentClass.getDeclaredField("age");
        age.set(day27Student, 20);
//        System.out.println(age.get(age));


        System.out.print(day27Student.getId() + ",");
        System.out.print(day27Student.getName() + ",");
        System.out.print(day27Student.age + ",");
        System.out.print(Day27Student.getClassName());
    }
}
