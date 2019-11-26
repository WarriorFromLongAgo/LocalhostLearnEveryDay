package com.fff.domain;

import java.io.Serializable;

/**
 * @PackageName：com.fff.domain
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/15 14:56
 */
public class UserInfo implements Serializable {
    private Integer userInfoId;
    private String userName;
    private String passWord;

    public UserInfo() {
    }

    public UserInfo(Integer userInfoId, String userName, String passWord) {
        this.userInfoId = userInfoId;
        this.userName = userName;
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userInfoId=" + userInfoId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
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
