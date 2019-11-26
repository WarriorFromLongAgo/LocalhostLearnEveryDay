package com.fff.service;

import com.fff.domain.UserInfo;

import java.util.List;

/**
 * @PackageName：com.fff.service
 * @ClassName：service 接口
 * @Description：
 * @author：
 * @date：2019/10/20 12:40
 */
public interface IUserService {
    List<UserInfo> findUserAllService();
}
