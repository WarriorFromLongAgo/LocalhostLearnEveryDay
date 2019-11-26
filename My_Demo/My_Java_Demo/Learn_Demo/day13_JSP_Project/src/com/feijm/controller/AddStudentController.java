package com.feijm.controller;

import com.feijm.model.dao.ProjectDaoImpl;
import com.feijm.model.entity.Student;
import com.feijm.model.service.ProjectService;
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

@WebServlet(urlPatterns = "/addStudentController")
public class AddStudentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> studentMap = request.getParameterMap();
        Student addStudent = new Student();
        try {
            BeanUtils.populate(addStudent, studentMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        ProjectService projectService = new ProjectServiceImpl();
        if (new ProjectServiceImpl().addStudentService(addStudent)) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

        request.getRequestDispatcher("Transit.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
