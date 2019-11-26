package com.day25_she_ji_mo_shi.singlecasedesign.lazydesign;

public class LazyDesign {
    private Integer age;
    private String name;

    private static LazyDesign instance;

    public static LazyDesign getInstance() {
        if (instance == null) {
            synchronized (LazyDesign.class) {
                if (instance == null) {
                    instance = new LazyDesign();
                }
            }
        }
        return instance;
    }

    private LazyDesign() {
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
