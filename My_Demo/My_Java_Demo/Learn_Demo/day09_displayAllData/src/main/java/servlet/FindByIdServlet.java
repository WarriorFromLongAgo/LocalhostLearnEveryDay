package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Student;
import service.ProjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/findByIdServlet")
public class FindByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println(id);
        Student byIdStudent = new ProjectServiceImpl().findByIdService(id);
        ObjectMapper objectMapper = new ObjectMapper();
        String byIdStudentJson = objectMapper.writeValueAsString(byIdStudent);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(byIdStudentJson);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
