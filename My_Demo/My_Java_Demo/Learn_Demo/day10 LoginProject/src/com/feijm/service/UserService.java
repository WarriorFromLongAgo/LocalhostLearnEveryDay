package com.feijm.service;

import com.feijm.dao.UserDao;
import com.feijm.model.User;
import com.feijm.util.JdbcDruidUtil;

import java.sql.Connection;

public class UserService {
    private UserDao userDao = new UserDao();
    private Connection connection = JdbcDruidUtil.getConnection();

    /*检测传入的账号密码是否是正确的，正确返回true，错误则返回一个false*/
    public boolean loginService(User loginUser) {
        return userDao.loginDao(loginUser) != null;
    }
}
