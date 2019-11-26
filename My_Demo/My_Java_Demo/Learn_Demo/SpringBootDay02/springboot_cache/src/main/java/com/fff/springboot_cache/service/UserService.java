package com.fff.springboot_cache.service;

import com.fff.springboot_cache.domain.UserInfo;
import com.fff.springboot_cache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName：com.fff.springboot_cache.service
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/19 11:26
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<UserInfo> findAllUserInfoService(){
        List<UserInfo> userInfoList = userMapper.findAllUserInfoAnnoMapper();

        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }

        return userInfoList;
    }

}
