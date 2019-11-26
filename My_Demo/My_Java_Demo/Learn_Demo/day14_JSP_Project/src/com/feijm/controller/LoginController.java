package com.feijm.controller;

import com.feijm.model.entity.Account;
import com.feijm.model.service.ProjectService;
import com.feijm.model.service.ProjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        设置请求中的文件格式
        request.setCharacterEncoding("utf-8");

//        后端验证码
        HttpSession session = request.getSession();
        String rearEndCheckCode = (String) session.getAttribute("rearEndCheckCode");
        session.removeAttribute("rearEndCheckCode");

        System.out.println("rearEndCheckCode = " + rearEndCheckCode);
//        前端验证码
        String frontEndCheckCode = request.getParameter("frontEndCheckCode");
        System.out.println("frontEndCheckCode = " + frontEndCheckCode);

//        验证码错误
        if (!rearEndCheckCode.equalsIgnoreCase(frontEndCheckCode)) {
            request.setAttribute("errorInfo", "验证码输入有误");
            request.getRequestDispatcher("index.jsp").forward(request, response);

            return;
        }

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        Account userAccount = new Account(userName, passWord);
        boolean loginFlag = new ProjectServiceImpl().loginService(userAccount);
//        ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl();
//        boolean loginFlag = projectServiceImpl.loginService(userAccount);
        if (!loginFlag) {
            request.setAttribute("errorInfo", "用户名或者密码错误");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            session.setAttribute("userAccount",userAccount);
            response.sendRedirect("Transit.jsp");
        }

        System.out.println("=======================");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
