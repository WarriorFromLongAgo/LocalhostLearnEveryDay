package com.feijm.controller;

import com.feijm.model.service.ProjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteController")
public class DeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1，获取id
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        boolean deleteFlag = new ProjectServiceImpl().deleteToIdService(id);
        if (deleteFlag) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        response.sendRedirect("Transit.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
