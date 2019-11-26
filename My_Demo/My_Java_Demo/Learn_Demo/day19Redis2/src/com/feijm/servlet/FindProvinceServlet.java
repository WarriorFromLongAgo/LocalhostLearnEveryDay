package com.feijm.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feijm.domain.Dept;
import com.feijm.service.DeptServiceImpl;
import com.feijm.service.IDeptService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/findProvinceServlet")
public class FindProvinceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        从数据库中获得数据
//        IDeptService iDeptService = new DeptServiceImpl();
//        List<Dept> deptList = iDeptService.findAllService();
//        for (Dept dept : deptList) {
//            System.out.println(dept);
//        }
//        response.setContentType("application/json;charset=utf-8");
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValue(response.getWriter(), deptList);

//        从Json中获得数据
        IDeptService iDeptService = new DeptServiceImpl();
        String deptListJson = iDeptService.findAllJsonService();
        System.out.println(deptListJson);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(deptListJson);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
