package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteSelectServlet")
public class DeleteSelectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deleteIdStr = request.getParameter("deleteIdStr");
        System.out.println(deleteIdStr);

//        首先检测传入的id，数据库中是否全部都有
        ObjectMapper objectMapper = new ObjectMapper();
        String trueJson = objectMapper.writeValueAsString("true");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(trueJson);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
