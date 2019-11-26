package com.feijm.xiangmu001.service;


import com.feijm.xiangmu001.domain.UserInfo;

public interface IUserService {
    boolean registerService(UserInfo userInfo);

    boolean activeService(String code);

    UserInfo loginService(String userName, String passWord);

}
