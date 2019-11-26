package com.fff.dao;

import com.fff.domain.UserInfo;

import java.util.List;

/**
 * @PackageName：com.fff.dao
 * @ClassName：dao接口
 * @Description：
 * @author：
 * @date：2019/10/20 12:40
 */
public interface IUserDao {

    List<UserInfo> findUserAllDao();

    int updateUserByUserDao(UserInfo userInfo);

    int insertUserDao(UserInfo userInfo);

    int deleteUserByIdDao(int userId);
}
