package com.fff.controller;

import com.fff.diyexception.DiyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/26 10:45
 */
@Controller
//@RequestMapping(path = "/user")
public class UserController {

    @RequestMapping(path = "/testAjax")
    public String testAjax() throws DiyException {
        System.out.println(" testAjax 打印 ");
        try {
            int i = 10 / 0;

        } catch (Exception e) {
            throw new DiyException("出现异常");
        }

        return "success";
    }

}
