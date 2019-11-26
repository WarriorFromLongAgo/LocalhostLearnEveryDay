package com.feijm.dao;

import com.feijm.domain.UserInfo;

import java.util.List;

public interface IUserInfoDao {

    List<UserInfo> findAllDao();
}
