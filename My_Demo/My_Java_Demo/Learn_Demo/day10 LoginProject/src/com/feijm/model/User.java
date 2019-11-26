package com.feijm.model;

public class User {
    private Integer id;
    private String userName;
    private String PASSWORD;

    public User() {
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.PASSWORD = passWord;
    }

    public User(Integer id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.PASSWORD = passWord;
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

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                '}';
    }
}
