package com.feijm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class People {
    private Integer id;
    private String userName;
//    @JsonFormat()
    private Date birthday;
    private String address;

    public People() {
    }

    public People(Integer id, String userName, Date birthday, String address) {
        this.id = id;
        this.userName = userName;
        this.birthday = birthday;
        this.address = address;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
