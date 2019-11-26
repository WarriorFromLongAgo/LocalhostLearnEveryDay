package com.day27_classLoader.classfeild;

public class Day27Student {
    private Integer id;
    private String name;
    public Integer age;
    private static String className;

    public Day27Student() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static String getClassName() {
        return className;
    }

    public static void setClassName(String className) {
        Day27Student.className = className;
    }

    public Day27Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
