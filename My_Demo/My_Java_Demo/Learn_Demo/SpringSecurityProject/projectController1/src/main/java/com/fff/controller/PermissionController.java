package com.fff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/12 19:09
 */
@Controller
@RequestMapping(value = "/permission")
public class PermissionController {

    @RequestMapping(value = "findAll")
    public ModelAndView findAllUserController() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("user-list");



        return modelAndView;
    }

}
