package com.feijm.controller;

import com.feijm.model.entity.Paging;
import com.feijm.model.entity.Student;
import com.feijm.model.service.ProjectService;
import com.feijm.model.service.ProjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/pageAllController")
public class PageAllController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String currentPage = request.getParameter("currentPage");
        String pageShowAnCount = request.getParameter("pageShowAnCount");
        Map<String, String[]> conditionStrStrArrMap = request.getParameterMap();

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (pageShowAnCount == null || "".equals(pageShowAnCount)) {
            pageShowAnCount = "5";
        }

        Paging<Student> paging = new ProjectServiceImpl().findByPageListService(currentPage, pageShowAnCount, conditionStrStrArrMap);

        request.setAttribute("paging", paging);
        request.setAttribute("condition", conditionStrStrArrMap);
        request.getRequestDispatcher("PagingAll.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
