package com.feijm.model.entity;

public class Account {
    private Integer id;
    private String userName;
    private String passWord;

    public Account() {
    }

    public Account(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
