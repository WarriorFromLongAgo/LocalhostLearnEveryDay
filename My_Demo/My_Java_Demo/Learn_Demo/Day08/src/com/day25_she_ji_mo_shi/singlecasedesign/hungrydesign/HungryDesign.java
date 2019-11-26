package com.day25_she_ji_mo_shi.singlecasedesign.hungrydesign;

public class HungryDesign {
    private Integer age;
    private String name;

    private static HungryDesign instance = new HungryDesign();

    private HungryDesign() {

    }

    public static HungryDesign getInstance() {
        return instance;
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
