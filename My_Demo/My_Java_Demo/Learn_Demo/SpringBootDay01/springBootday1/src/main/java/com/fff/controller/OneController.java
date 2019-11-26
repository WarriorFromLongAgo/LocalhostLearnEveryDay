package com.fff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/14 21:19
 */
@Controller
public class OneController {

    @RequestMapping(value = "/one")
    @ResponseBody
    public String one(){


        return  "hello spring boot";
    }
}
