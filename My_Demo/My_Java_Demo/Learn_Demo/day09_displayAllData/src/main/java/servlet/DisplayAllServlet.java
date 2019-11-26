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
import java.util.List;

@WebServlet(urlPatterns = "/displayAllServlet")
public class DisplayAllServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("displayAllServlet");
//        获得所有人的数据
        List<Student> studentList = new ProjectServiceImpl().findAllService();
//        获得JackSon的主对象
        ObjectMapper objectMapper = new ObjectMapper();
//        将list数据转变为String数据
        String studentListJson = objectMapper.writeValueAsString(studentList);
        System.out.println(studentListJson);
//        输出到另一边
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(studentListJson);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
