package com.fff.controller;

import com.fff.domain.UserInfo;
import com.fff.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/15 15:18
 */
@Controller
public class JPAController {

    @Autowired
    UserRepository userRepository;

    @ResponseBody
    @RequestMapping(value = "/user")
    public List<UserInfo> findAllUserInfoController(){
        List<UserInfo> userInfoList = userRepository.findAll();
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }
        return userInfoList;
    }

    @ResponseBody
    @RequestMapping(value = "/user/{resultId}")
    public UserInfo findUserInfoByIdController(@PathVariable("resultId") Integer resultId){
        Optional<UserInfo> userInfo = userRepository.findById(resultId);

        return userInfo.get();
    }

    @RequestMapping(value = "/addUser")
    public UserInfo findUserInfoByIdController(UserInfo userInfo){
        UserInfo userInfo1 = userRepository.save(userInfo);
        System.out.println(userInfo1);
        return userInfo1;
    }
}
