package com.fff.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @PackageName：com.fff.domain
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/3 19:28
 */
@Component
public class UserInfo implements Serializable {

    private Integer aid;
    private String userName;
    private Double money;

    public UserInfo() {
    }

    public UserInfo(String userName, Double money) {
        this.userName = userName;
        this.money = money;
    }

    public UserInfo(Integer aid, String userName, Double money) {
        this.aid = aid;
        this.userName = userName;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account {" +
                "aid=" + aid +
                ", userName='" + userName + '\'' +
                ", money=" + money +
                '}';
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

}
