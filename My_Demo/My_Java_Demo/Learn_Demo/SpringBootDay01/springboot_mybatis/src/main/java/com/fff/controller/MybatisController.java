package com.fff.controller;

import com.fff.domain.UserInfo;
import com.fff.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/15 15:18
 */
@Controller
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping(value = "/findAll")
    public List<UserInfo> findAllUserInfoController(){
        List<UserInfo> userInfoList = userMapper.findAllUserInfoMapper();
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }
        return userInfoList;
    }


    @ResponseBody
    @RequestMapping(value = "/findAllAnno")
    public List<UserInfo> findAllUserInfoAnnoController(){
        List<UserInfo> userInfoList = userMapper.findAllUserInfoAnnoMapper();
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }
        return userInfoList;
    }

}

