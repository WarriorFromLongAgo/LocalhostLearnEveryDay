package com.feijm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(urlPatterns = "/cookieDemo2")
public class cookieDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取cookie
        Cookie[] cookieArr = request.getCookies();
        if (cookieArr != null) {
            for (Cookie cookie : cookieArr) {
                String name = cookie.getName();

                String value = cookie.getValue();
                System.out.print("name = " + name);
                System.out.println("-----value = " + value);
            }
        }
        System.out.println("=-=======================================");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
