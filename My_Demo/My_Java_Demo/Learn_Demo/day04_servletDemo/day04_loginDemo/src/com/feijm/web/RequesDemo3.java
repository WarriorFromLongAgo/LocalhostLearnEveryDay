package com.feijm.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/request3")
public class RequesDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求头数据 referer
        String referer = request.getHeader("referer");
        System.out.println(referer);
        if (referer != null) {
            if (referer.contains("xxx")) {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("想看电影吗，来优酷吧");
            }
        }
    }
}
