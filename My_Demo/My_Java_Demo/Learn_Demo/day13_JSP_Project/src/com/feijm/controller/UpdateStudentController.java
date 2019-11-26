package com.feijm.controller;

import com.feijm.model.entity.Student;
import com.feijm.model.service.ProjectServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(urlPatterns = "/updateStudentController")
public class UpdateStudentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> updateMap = request.getParameterMap();
        Student student = new Student();

        try {
            BeanUtils.populate(student, updateMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(student);
        boolean updateFlag = new ProjectServiceImpl().updateStudentService(student);
        if (updateFlag) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        response.sendRedirect("Transit.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
