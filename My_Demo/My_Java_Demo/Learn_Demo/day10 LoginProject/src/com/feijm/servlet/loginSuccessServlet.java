package com.feijm.servlet;

import com.feijm.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginSuccess")
public class loginSuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  获取request域中的共享的user对象
        User user = (User) request.getAttribute("user");
        if (user != null) {
            response.setHeader("content-type", "text/html;charset=utf-8");
            //  给页面谢一句话，设置页面的编码
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登录成功！" + user.getUserName() + "，欢迎您");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
