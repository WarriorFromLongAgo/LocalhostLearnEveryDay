//package com.feijm.xiangmu001.web.servlet;
//
//import com.feijm.xiangmu001.domain.ResultInfo;
//import com.feijm.xiangmu001.service.IUserService;
//import com.feijm.xiangmu001.service.impl.UserServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/activeServlet")
//public class ActiveServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String code = request.getParameter("code");
//        System.out.println(code);
//
//        IUserService userService = new UserServiceImpl();
//        boolean activeFlag = userService.activeService(code);
//
//        String message = null;
//        if (activeFlag) {
//            System.out.println("11111111");
//            message = "激活成功：<a href='" + request.getContextPath() + "/login.html'>点击跳转页面</a>";
//        } else {
//            System.out.println("0000000");
//            message = "验证码错误，请联系管理员";
//        }
//        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().write(message);
////        response.sendRedirect(request.getContextPath() + "/isactive.html");
//
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
//}
