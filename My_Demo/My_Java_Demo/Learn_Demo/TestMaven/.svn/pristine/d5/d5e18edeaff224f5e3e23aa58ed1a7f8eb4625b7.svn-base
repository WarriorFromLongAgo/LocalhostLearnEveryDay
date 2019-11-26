package com.fff.service.impl;

import com.fff.dao.IUserDao;
import com.fff.domain.UserInfo;
import com.fff.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName：com.fff.service.impl
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/3 19:36
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public Integer insertUserService(UserInfo userInfo) {
        System.out.println(" insertUserService ");
        return userDao.insertUserDao(userInfo);
    }

    @Override
    public Integer deleteUserByAidService(Integer aid) {
        System.out.println(" deleteUserByAidService ");
        return userDao.deleteUserByAidDao(aid);
    }

    @Override
    public Integer updateUserByUserService(UserInfo userInfo) {
        System.out.println(" updateUserByUserService ");
        return userDao.updateUserByUserDao(userInfo);
    }

    @Override
    public UserInfo findUserByAidService(Integer aid) {
        System.out.println(" findUserByAidService ");
        return userDao.findUserByAidDao(aid);
    }

    @Override
    public List<UserInfo> findUserAllService() {
        System.out.println(" findUserAllService ");
        return userDao.findUserAllDao();
    }
}
