package com.feijm.travel.service.impl;

import com.feijm.travel.dao.IUserDao;
import com.feijm.travel.dao.impl.UserDaoImpl;
import com.feijm.travel.domain.UserInfo;
import com.feijm.travel.service.IUserService;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new UserDaoImpl();

    @Override
    public boolean register(UserInfo userInfo) {
        UserInfo byUserNameDao = userDao.findByUserNameDao(userInfo.getUsername());
        if (byUserNameDao != null) {
//        1，根据用户名查询一次，用户存在就返回false
            return false;
        }

//        2，不存在就保存用户信息
        return userDao.registerDao(userInfo);
    }
}
