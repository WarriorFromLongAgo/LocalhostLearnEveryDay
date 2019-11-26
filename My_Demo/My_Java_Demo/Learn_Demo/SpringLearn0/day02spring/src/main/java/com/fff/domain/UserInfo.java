package com.fff.domain;

import org.springframework.stereotype.Component;

/**
 * @PackageName：com.fff.domain
 * @ClassName：实体类
 * @Description：
 * @author：
 * @date：2019/10/20 12:40
 */
public class UserInfo {
    private int userId;
    private String userName;
    private String passWord;

    public UserInfo() {
    }

    public UserInfo(int userId, String userName, String passWord) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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


    @Override
    public String toString() {
        return "UserInfo {" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
