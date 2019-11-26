package com.fff.domain;

/**
 * @PackageName：com.fff.domain
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/21 20:30
 */
public class UserInfo {
    private int userId;
    private String userName;
    private String passWord;

    private UserCard userCard;


    public UserInfo() {
    }

    public UserInfo(int userId, String userName, String passWord) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userCard=" + (userCard == null ? "" : userCard) +
                '}';
    }

    public UserCard getUserCard() {
        return userCard;
    }

    public void setUserCard(UserCard userCard) {
        this.userCard = userCard;
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
}
