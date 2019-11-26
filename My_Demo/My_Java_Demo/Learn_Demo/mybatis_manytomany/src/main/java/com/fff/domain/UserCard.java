package com.fff.domain;

/**
 * @PackageName：com.fff.domain
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/21 20:32
 */
public class UserCard {
    private int cardId;
    private int userId;
    private String cardNum;

    public UserCard() {
    }

    public UserCard(int cardId, int userId, String cardNum) {
        this.cardId = cardId;
        this.userId = userId;
        this.cardNum = cardNum;
    }

    @Override
    public String toString() {
        return "UserCard {" +
                "cardId=" + cardId +
                ", userId=" + userId +
                ", cardNum='" + cardNum + '\'' +
                '}';
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}
