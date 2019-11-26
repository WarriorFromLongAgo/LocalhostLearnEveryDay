package com.feijm.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/request2")
public class RequesDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        String getHeader(String name):通过请求头的名称，获取请求头的值
        Enumeration<String> getHeaderNames()：获取所有的请求头的名称*/
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String names = headerNames.nextElement();
            String header = request.getHeader(names);
            System.out.print(names);
            System.out.println("----" + header);
        }
    }
}
