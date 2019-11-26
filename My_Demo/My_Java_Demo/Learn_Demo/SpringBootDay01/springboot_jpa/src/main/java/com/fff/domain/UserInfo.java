package com.fff.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @PackageName：com.fff.domain
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/15 14:56
 */
//使用JPA注解配置映射关系
//告诉JPA是一个实体类（和数据库表映射的表）
@Entity
//告诉JPA和哪个表相互映射，如果省略默认是 userinfo
@Table(name = "userinfo")
public class UserInfo implements Serializable {
//    设置为主键
    @Id
//    设置为自增主键
    @Column(name = "userInfoId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userInfoId;
//    设置和哪一列映射，长度为50
    @Column(name = "username", length = 50)
    private String userName;
//    如果那么省略，那么默认为password映射
    @Column(name = "password")
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
