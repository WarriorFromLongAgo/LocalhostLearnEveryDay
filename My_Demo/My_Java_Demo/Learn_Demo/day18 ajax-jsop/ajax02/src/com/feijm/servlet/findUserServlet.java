package com.feijm.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/findUserServlet")
public class findUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String userName = request.getParameter("userName");
        System.out.println(userName);
        Map<String, Object> strObjMap = new HashMap<>();
        response.setContentType("application/json;charset=utf-8");

        if ("feijm".equals(userName)) {
//            存在
            strObjMap.put("userExsit", true);
            strObjMap.put("message", "此用户名太受欢迎了，请更换");
        } else {
//            不存在
            strObjMap.put("userExsit", false);
            strObjMap.put("message", "用户名可用");
        }

//        将map转为json
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(), strObjMap);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
