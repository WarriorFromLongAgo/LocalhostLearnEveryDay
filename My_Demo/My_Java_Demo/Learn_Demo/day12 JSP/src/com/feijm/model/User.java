package com.feijm.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String userName;
    private String passWord;
    private Integer age;
    private Date birthday;

    public User() {
    }

    public User(String userName, String passWord, Integer age) {
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
    }

    public User(String userName, String passWord, Integer age, Date birthday) {
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String changeBirthday(Date birthday) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthdayStr = simpleDateFormat.format(birthday);
        return birthdayStr;
    }
}
