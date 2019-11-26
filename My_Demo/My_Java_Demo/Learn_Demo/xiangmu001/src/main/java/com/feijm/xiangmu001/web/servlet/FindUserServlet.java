//package com.feijm.xiangmu001.web.servlet;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/findUserServlet")
//public class FindUserServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Object user = request.getSession().getAttribute("user");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String userStrJson = objectMapper.writeValueAsString(user);
//        response.setContentType("application/json;charset=utf-8");
//        response.getWriter().write(userStrJson);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
//}
