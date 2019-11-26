package com.feijm.xiangmu001.dao;


import com.feijm.xiangmu001.domain.UserInfo;

public interface IUserDao {
    UserInfo findByUserNameDao(String userName);

    String findByCodeDao(String code, String status);

    boolean activeDao(String status, String userName);

    boolean registerDao(UserInfo userInfo);

    UserInfo loginDao(String userName, String passWord);

}
