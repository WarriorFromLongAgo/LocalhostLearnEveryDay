package com.feijm.servlet;

import com.feijm.model.User;
import com.feijm.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  设置传入的参数的格式
        request.setCharacterEncoding("utf-8");
        //  获得传入的参数，账号和密码
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        System.out.println(userName);
        System.out.println(passWord);
        User loginUser = new User(userName, passWord);
        //  调用service层，进行输入数据的处理
        UserService userService = new UserService();
        boolean flag = userService.loginService(loginUser);
        System.out.println(flag);
        if (flag) {
            //  存在，就是登录成功
            request.setAttribute("user", loginUser);
            request.getRequestDispatcher("/loginSuccess").forward(request, response);
        } else {
            //  不存在，就是登录失败
            request.getRequestDispatcher("/loginFail").forward(request, response);
        }
    }
}
