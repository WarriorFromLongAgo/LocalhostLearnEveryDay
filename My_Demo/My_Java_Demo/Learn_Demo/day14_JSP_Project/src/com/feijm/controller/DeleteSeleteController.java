package com.feijm.controller;

import com.feijm.model.service.ProjectService;
import com.feijm.model.service.ProjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteSeleteController")
public class DeleteSeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String[] tabs = request.getParameterValues("tab");
        ProjectService projectService = new ProjectServiceImpl();

        if (tabs != null && tabs.length > 0) {
            for (String tab : tabs) {
                boolean deleteFlag = projectService.deleteToIdService(tab);
                if (deleteFlag) {
                    System.out.println("tab = " + tab + " = 删除成功");
                } else {
                    System.out.println("tab = " + tab + " = 删除失败");
                }
            }
        }
        response.sendRedirect("Transit.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
