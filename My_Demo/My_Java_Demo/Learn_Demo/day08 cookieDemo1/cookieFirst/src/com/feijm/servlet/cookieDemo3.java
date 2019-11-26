package com.feijm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/cookieDemo3")
public class cookieDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("username", "123456");
        Cookie cookie1 = new Cookie("password", "123456");
        Cookie cookie3 = new Cookie("33333333", "123456");
        Cookie cookie4 = new Cookie("44444444", "123456");
        String cookie5Value = "1234 56";

        String encodeCookie5Value = URLEncoder.encode(cookie5Value, "utf-8");


        Cookie cookie5 = new Cookie("5555555", encodeCookie5Value);
        cookie.setMaxAge(120);
        cookie1.setMaxAge(30);
        cookie3.setMaxAge(-1);
        cookie4.setMaxAge(1000);
        cookie5.setMaxAge(1000);

        response.addCookie(cookie);
        response.addCookie(cookie1);
        response.addCookie(cookie3);
        response.addCookie(cookie4);
        response.addCookie(cookie5);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
