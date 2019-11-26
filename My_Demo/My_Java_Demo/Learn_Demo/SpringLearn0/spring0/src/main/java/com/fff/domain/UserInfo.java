package com.fff.domain;

import com.sun.scenario.effect.impl.prism.PrImage;

/**
 * @PACKAGE_NAME: com.fff.domain
 * @ClassName: User
 * @auther: RedBeanIce
 * @Date:2019/10/19 14:59
 * @<version>:1.0.0
 * @<desc>描述:
 * @<desc>描述:
 * @<desc>描述:
 * @Description: User数据表的实体类
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
        return "User {" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
