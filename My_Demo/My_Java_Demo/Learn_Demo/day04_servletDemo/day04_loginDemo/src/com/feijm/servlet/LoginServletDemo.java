package com.feijm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget.....................");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dopost////////////////////////////");
        String userName = req.getParameter("userName");
        System.out.println("userName = " + userName);
        String passWord = req.getParameter("passWord");
        System.out.println("passWord = " + passWord);

        if ("feijm".equals(userName) && "123456".equals(passWord)) {
            resp.sendRedirect("index.jsp");
        } else {
            resp.sendRedirect("shibai.html");
        }
        System.out.println("结束");
    }
}
