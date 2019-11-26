package com.feijm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginSessionDemo")
public class LoginSessionDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        设置请求中的文件格式
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        String rearEndCheckCode = (String) session.getAttribute("rearEndCheckCode");
        session.removeAttribute("rearEndCheckCode");
        System.out.println("rearEndCheckCode = " + rearEndCheckCode);

        String frontEndCheckCode = request.getParameter("frontEndCheckCode");
        System.out.println("frontEndCheckCode = " + frontEndCheckCode);

        String errorInfo = null;
        boolean checkCodeFlag = false;
        if (rearEndCheckCode.equalsIgnoreCase(frontEndCheckCode)) {
            checkCodeFlag = true;
        } else {
//            验证码错误
            errorInfo = "验证码输入有误";
            System.out.println(errorInfo);
            request.setAttribute("errorInfo", errorInfo);
            request.getRequestDispatcher("failLogin.html").forward(request, response);
        }

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        if (checkCodeFlag) {
            if ("feijm".equals(userName) && "123".equals(passWord)) {
                session.setAttribute("userName", userName);
                System.out.println("登陆成功");
                request.getRequestDispatcher("successLogin.html").forward(request, response);
            } else {
                errorInfo = "账号密码输入错误";
                System.out.println(errorInfo);
                request.setAttribute("errorInfo", errorInfo);
                request.getRequestDispatcher("failLogin.html").forward(request, response);
            }
        }

        System.out.println("=======================");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
