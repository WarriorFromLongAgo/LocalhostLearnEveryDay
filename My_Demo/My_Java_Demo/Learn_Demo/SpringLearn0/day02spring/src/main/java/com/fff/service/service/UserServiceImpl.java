package com.fff.service.service;

import com.fff.dao.IUserDao;
import com.fff.domain.UserInfo;
import com.fff.service.IUserService;

import java.util.List;

/**
 * @PackageName：com.fff.service.service
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/20 15:18
 */

public class UserServiceImpl implements IUserService {
    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }


    
    /**
     * @Author 
     * @Description 
     * @Date 2019/10/20 19:29
     * @Param 
     * @return 
     **/
    public List<UserInfo> findUserAllService() {

        return userDao.findUserAllDao();
    }

    public int updateUserByUserService(UserInfo userInfo) {

        return userDao.updateUserByUserDao(userInfo);
    }

    public int insertUserService(UserInfo userInfo) {

        return userDao.insertUserDao(userInfo);
    }

    public int deleteUserByIdService(int userId) {

        return userDao.deleteUserByIdDao(userId);
    }
}
