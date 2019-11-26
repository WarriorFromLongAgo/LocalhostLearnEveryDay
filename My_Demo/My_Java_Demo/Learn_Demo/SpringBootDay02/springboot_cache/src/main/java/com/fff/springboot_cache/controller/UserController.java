package com.fff.springboot_cache.controller;

import com.fff.springboot_cache.domain.UserInfo;
import com.fff.springboot_cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @PackageName：com.fff.springboot_cache.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/19 11:30
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/user/findAll")
    @Cacheable(cacheNames = {"user"})
    public List<UserInfo> findAllUserInfoController(){
        List<UserInfo> userInfoList = userService.findAllUserInfoService();

        System.out.println("findAllUserInfoController");

        return userInfoList;
    }


}
