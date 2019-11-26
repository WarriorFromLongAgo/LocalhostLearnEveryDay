package com.fff.domain;

/**
 * @PackageName：com.fff.domain
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/22 19:25
 */
public class Transfer {

    private int userId;
    private String userName;
    private double money;

    public Transfer() {
    }

    public Transfer(int userId, String userName, double money) {
        this.userId = userId;
        this.userName = userName;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Transfer {" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", money=" + money +
                '}';
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
