package com.fff.controller;

import com.fff.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(path = "/testString")
    public String textString() {

        System.out.println(" testString ");

        return "success";
    }

    @RequestMapping(path = "/testString2")
    public String textString2(Model model) {

        UserInfo userInfo = new UserInfo("textString2", "textString2");

        System.out.println(" testString2 打印 ");
        model.addAttribute("userInfo", userInfo);

        return "success";
    }

    /*
     * 如果没有写返回值，默认会去访问   textVoid 拼接的界面
     * 但是没有 response 就不可以，会报404
     * */
    @RequestMapping(path = "/textVoid")
    public void textVoidTest(Model model, HttpServletRequest request, HttpServletResponse response) {
        UserInfo userInfo = new UserInfo("textVoid", "textVoid");

        model.addAttribute("userInfo", userInfo);
        System.out.println(" textVoid 打印 ");
        try {
            request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(path = "/textVoid2")
    public void textVoidTest2(Model model, HttpServletRequest request, HttpServletResponse response) {
        UserInfo userInfo = new UserInfo("textVoid", "textVoid");

        model.addAttribute("userInfo", userInfo);
        System.out.println(" textVoid2 打印 ");
        try {
            /*重定向不允许进去WEB-INF*/
            String ss = request.getContextPath() + "/WEB-INF/views/success.jsp";
            System.out.println(ss);
            response.sendRedirect(ss);

//            会输出一个什么的页面
            response.getWriter().print("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(path = "/textModelAndView")
    public ModelAndView textModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = new UserInfo("textString2", "textString2");

        System.out.println(" textModelAndView 打印 ");
        modelAndView.addObject(userInfo);
        modelAndView.setViewName("success");

        return modelAndView;
    }


    @RequestMapping(path = "/testForwardOrRedirect")
    public String testForwardOrRedirect() {

        System.out.println(" testForwardOrRedirect 打印 ");

        return "forward:/WEB-INF/views/success.jsp";
    }

    @RequestMapping(path = "/testRedirect")
    public String testRedirect() {

        System.out.println(" testRedirect 打印 ");

//        重定向到其他的方法
        return "redirect:index.jsp";
//        return "redirect:testForwardOrRedirect";
    }


    @RequestMapping(path = "/testAjax")
    public @ResponseBody
    UserInfo testAjax(@RequestBody UserInfo userInfo) {
        System.out.println(" testAjax 打印 ");
        System.out.println(userInfo);
        userInfo.setPassWord("testAjax  setPassWord");
        userInfo.setUserName("testAjax  setUserName");
        return userInfo;
    }

    @RequestMapping(path = "/testAjax2")
    @ResponseBody
    public List<UserInfo> testAjax2() {
        List<UserInfo> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            UserInfo userinfo = new UserInfo();

            userinfo.setPassWord("testAjax  setPassWord");
            userinfo.setUserName("testAjax  setUserName");

            list.add(userinfo);
        }

        return list;
    }

//    不可行
//    @RequestMapping(path = "/testAjax")
//    public UserInfo testAjax2(UserInfo userInfo) {
//        System.out.println(" testAjax 打印 ");
//        System.out.println(userInfo);
//        userInfo.setPassWord("testAjax  setPassWord");
//        userInfo.setUserName("testAjax  setUserName");
//        return userInfo;
//    }

}
