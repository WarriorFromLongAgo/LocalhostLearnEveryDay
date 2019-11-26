package com.feijm.jdbctemplate;

public class Student {
    private Integer id;
    private String NAME;
    private Integer age;
    private String sex;
    private String address;
    private Integer math;
    private Integer english;

    public Student() {
    }

    public Student(Integer id, String NAME, Integer age, String sex, String address, Integer math) {
        this.id = id;
        this.NAME = NAME;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.math = math;
    }
    public Student(Integer id, String NAME, Integer age, String sex, String address, Integer math, Integer english) {
        this.id = id;
        this.NAME = NAME;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.math = math;
        this.english = english;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", math=" + math +
                ", english=" + english +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }
}
