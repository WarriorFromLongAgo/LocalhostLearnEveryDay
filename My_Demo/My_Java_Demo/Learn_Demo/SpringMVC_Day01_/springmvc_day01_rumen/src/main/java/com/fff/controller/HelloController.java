package com.fff.controller;

import com.fff.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;
import java.util.Date;
import java.util.Map;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/23 20:26
 */
@Controller
public class HelloController {

    //  请求映射
    @RequestMapping(path = "/hello")
    public String sayHello() {

        System.out.println(" HelloController sayHello ");
        return "success";
    }

    @RequestMapping(path = "/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        String parameter = request.getParameter("11");
        System.out.println(parameter);
        return parameter;
    }

    @RequestMapping(path = "/testServlet")
    public String testRequestParam(@RequestParam(value = "name", required = true) String username) {

        System.out.println(username);
        return username;
    }

    @RequestMapping(path = "/testServlet")
    public String testRequestBody(@RequestBody String body) {

        System.out.println(body);
        return body;
    }


    @RequestMapping(path = "/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(value = "sid") String id) {

        System.out.println(id);
        return id;
    }

///////////////////////////////////////////////////////////////////////////////
    @RequestMapping(path = "/testModelAttribute")
    public String testModelAttribute(@ModelAttribute(value = "abc") User user) {

        System.out.println(user);
        return "success";
    }
    @ModelAttribute
    public void showUser(String username, Map<String, User> userMap) {
        System.out.println("showUser");
        User user = new User(username, "20", new Date());
        userMap.put("abc", user);
    }

///////////////////////////////////////////////////////////////////////////////

    @RequestMapping(path = "/testModelAttribute")
    public String testModelAttribute2( User user) {

        System.out.println(user);
        return "success";
    }
    @ModelAttribute
    public User showUser2(String username, Map<String, User> userMap) {
        System.out.println("showUser");
        User user = new User(username, "20", new Date());
        return user;
    }
////////////////////////////////////////////////////////////////////////////////////
}
