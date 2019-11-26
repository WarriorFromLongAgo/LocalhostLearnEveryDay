package com.fff.controller;

import com.fff.domain.Role;
import com.fff.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/12 19:09
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    @Qualifier(value = "roleService")
    private IRoleService roleService;

    @RequestMapping(value = "findAll")
    public ModelAndView findAllUserController() {
        ModelAndView modelAndView = new ModelAndView();

        List<Role> roleList = roleService.findAllRoleService();
        System.out.println(" roleList 打印");
        for (Role role : roleList) {
            System.out.println(role);
        }

        modelAndView.addObject("roleList", roleList);

        modelAndView.setViewName("role-list");

        return modelAndView;
    }

    @RequestMapping(value = "findPermissionByRoleId")
    public ModelAndView findPermissionByRoleIdController() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("role-list");

        return modelAndView;
    }

    @RequestMapping(value = "findById")
    public ModelAndView findByIdController() {
        ModelAndView modelAndView = new ModelAndView();



        modelAndView.setViewName("role-list");

        return modelAndView;
    }

}
