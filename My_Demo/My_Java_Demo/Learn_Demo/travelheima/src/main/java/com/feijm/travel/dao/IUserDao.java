package com.feijm.travel.dao;

import com.feijm.travel.domain.UserInfo;

public interface IUserDao {
    public abstract UserInfo findByUserNameDao(String userName);

    public abstract boolean registerDao(UserInfo userInfo);
}
