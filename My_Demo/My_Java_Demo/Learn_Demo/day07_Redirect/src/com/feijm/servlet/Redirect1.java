package com.feijm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
* 在 1 里面完成重定向
* */

@WebServlet(urlPatterns = "/redirect1")
public class Redirect1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1.。。。。。。。。。。。。。。。。");
        //  访问 /redirect1 ，会自动跳转到 /redirect2 的资源

//        1，设置状态码为302
//        response.setStatus(302);
////        2，设置响应头，location
//        response.setHeader("location","/day07_Redirect/redirect2");


        response.sendRedirect("/day07_Redirect/redirect2");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
