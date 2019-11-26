package com.fff.controller;

import com.fff.domain.UserInfo;
import com.fff.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/3 19:35
 */
@Controller
@RequestMapping(value = "/user")
@Api(description = "用户模块")
public class UserController {

    @Autowired
    @Qualifier(value = "userService")
    private IUserService userService;

    @ApiOperation(value = "添加用户控制器", notes = "根据xxx插入")
    @GetMapping("/insert")
    public ModelAndView insertUserController(UserInfo userInfo) {
        ModelAndView modelAndView = new ModelAndView();

        Integer integer = userService.insertUserService(userInfo);
        System.out.println(integer);

        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteUserByAidController(Integer aid) {
        ModelAndView modelAndView = new ModelAndView();

        Integer integer = userService.deleteUserByAidService(aid);
        System.out.println(integer);

        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView updateUserByUserController(UserInfo userInfo) {
        ModelAndView modelAndView = new ModelAndView();

        Integer integer = userService.updateUserByUserService(userInfo);
        System.out.println(integer);

        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @RequestMapping("/findByAid")
    public ModelAndView findUserByAidController(Integer aid) {
        ModelAndView modelAndView = new ModelAndView();

        UserInfo userInfo = userService.findUserByAidService(aid);
        System.out.println(userInfo);

        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @ApiImplicitParam(value = "昵称", name = "nickname", required = true, example = "张")
    @RequestMapping("/findAll")
    public ModelAndView findUserAllController() {
        ModelAndView modelAndView = new ModelAndView();

        List<UserInfo> userInfoList = userService.findUserAllService();
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }

        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @RequestMapping("/boke")
    public String findboke() {
        System.out.println("1111111111111");
        return "forward:/WEB-INF/views/boke.html";
    }

}
