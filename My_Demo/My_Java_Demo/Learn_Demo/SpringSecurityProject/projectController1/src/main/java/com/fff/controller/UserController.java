package com.fff.controller;

import com.fff.dao.IUserInfoDao;
import com.fff.domain.UserInfo;
import com.fff.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/12 18:59
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    @Qualifier(value = "userService")
    private IUserService userService;


    @RequestMapping(value = "/findAll")
    public ModelAndView findAllUserController() {


        System.out.println(" findAllUserController 1 ");

        List<UserInfo> userInfoList = userService.findAllUserService();

        System.out.println(" userInfoList Controller 2 ");
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("user-list");
        modelAndView.addObject("userInfoList", userInfoList);

        System.out.println(" findAllUserController 3 ");


        return modelAndView;
    }

    @RequestMapping(value = "/findById")
    public ModelAndView findUserByIdController(Integer userInfoId) {

        System.out.println(" findUserByIdController 1 userInfoId = " + userInfoId);

        UserInfo userInfo = userService.findUserInfoByIdService(userInfoId);
        System.out.println(userInfo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userInfo", userInfo);
        modelAndView.setViewName("user-show");

        System.out.println(" findUserByIdController 3 ");

        return modelAndView;
    }


    @RequestMapping(value = "/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRoleController() {

        System.out.println(" findUserByIdAndAllRoleController 1 ");

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("user-show");

        System.out.println(" findUserByIdAndAllRoleController 3 ");

        return modelAndView;
    }

    @RequestMapping(value = "/addUser")
    public String addUserController(UserInfo userInfo) {

        System.out.println(" addUserController 1 ");
        System.out.println("userInfo = " + userInfo);

        Integer integer = userService.addUserService(userInfo);
        System.out.println(integer > 0);

        System.out.println(" addUserController 3 ");


        return "redirect:/user/findAll";
//        return "redirect:/user/findAll;
//        return  "redirect:/product/findAll";
    }
}
