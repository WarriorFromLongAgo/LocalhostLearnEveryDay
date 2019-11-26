package com.fff.service;

import com.fff.domain.Role;
import com.fff.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @PackageName：com.fff.service
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/11 21:09
 */
public interface IUserService extends UserDetailsService {

    List<UserInfo> findAllUserService();

    UserInfo findUserInfoByIdService(Integer userInfoId);

    Integer addUserService(UserInfo userInfo);


}
