package com.fff.thymeleaf1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName：com.fff.thymeleaf1.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/16 17:06
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String helloController(Map<String, Object> map) {
        map.put("hello", "你好");

        System.out.println(map.get("hello"));

        return "success";
    }

    @RequestMapping("/hello2")
    public String hello2Controller( ) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("hello2", "你好2");

        return "success";
    }

    @RequestMapping("/hello3")
    public String hello3Controller(Model model) {

        model.addAttribute("hello3", "你好3");

        return "success";
    }
}
