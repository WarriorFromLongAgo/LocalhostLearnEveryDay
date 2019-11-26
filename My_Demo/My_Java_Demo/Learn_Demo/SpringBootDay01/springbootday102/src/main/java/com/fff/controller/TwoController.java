package com.fff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/14 21:38
 */
@Controller
public class TwoController {

    @ResponseBody
    @RequestMapping(value = "/three")
    public String three(){

        return "fffffff  spring boot";
    }


}
