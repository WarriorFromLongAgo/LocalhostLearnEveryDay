package com.day27_classLoader.classconstructor;

public class day27Student {
    private Integer id;
    private String name;

    public day27Student() {
    }

    public day27Student(Integer id, String name) {
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
