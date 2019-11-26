package com.fff.controller;

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
@RequestMapping(path = "/interceptor")
public class InterceptorController {

    @RequestMapping(path = "/testInterceptor")
    public String testInterceptor()  {
        System.out.println(" testInterceptor 打印 ");

        return "success";
    }

}
