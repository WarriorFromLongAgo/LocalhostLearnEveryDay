package com.fff.service;

import com.fff.domain.UserInfo;

import java.util.List;

/**
 * @PackageName：com.fff.service
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/3 19:35
 */
public interface IUserService {

    /**
     * @param userInfo :
     * @Title:
     * @MethodName: insertUserService
     * @Return java.lang.Integer
     * @Description:
     * @Description:
     * @Description:
     * @author: 作者名
     * @date: 2019/11/3 19:54
     */
    Integer insertUserService(UserInfo userInfo);

    /**
     * @param aid :
     * @Title:
     * @MethodName: deleteUserByAidService
     * @Return java.lang.Integer
     * @Description:
     * @Description:
     * @Description:
     * @author: 作者名
     * @date: 2019/11/3 19:54
     */
    Integer deleteUserByAidService(Integer aid);


    /**
     * @param userInfo :
     * @Title:
     * @MethodName: updateUserByUserService
     * @Return java.lang.Integer
     * @Description:
     * @Description:
     * @Description:
     * @author: 作者名
     * @date: 2019/11/3 19:54
     */
    Integer updateUserByUserService(UserInfo userInfo);

    /**
     * @param aid :
     * @Title:
     * @MethodName: findUserByAidService
     * @Return com.fff.domain.UserInfo
     * @Description:
     * @Description:
     * @Description:
     * @author: 作者名
     * @date: 2019/11/3 19:54
     */
    UserInfo findUserByAidService(Integer aid);

    /**
     * @Title:
     * @MethodName: findUserAllService
     * @Return java.util.List<com.fff.domain.UserInfo>
     * @Description:
     * @Description:
     * @Description:
     * @author: 作者名
     * @date: 2019/11/3 19:55
     */
    List<UserInfo> findUserAllService();

}
