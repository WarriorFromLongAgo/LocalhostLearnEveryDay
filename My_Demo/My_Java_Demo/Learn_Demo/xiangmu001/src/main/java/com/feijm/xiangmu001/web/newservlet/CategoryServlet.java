package com.feijm.xiangmu001.web.newservlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feijm.xiangmu001.domain.Category;
import com.feijm.xiangmu001.service.ICategoryService;
import com.feijm.xiangmu001.service.impl.CategoryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/category/*")
public class CategoryServlet extends BaseServlet {
    public void findAll(HttpServletRequest request, HttpServletResponse response) {

        try {
            ICategoryService categoryService = new CategoryServiceImpl();
//            System.out.println("findAll CategoryServlet");
            String categoryListJson = categoryService.findCategoryListJsonService();

            response.setContentType("application/json;charset=utf-8");
            System.out.println("--------------");

//            System.out.println("返回了");
            response.getWriter().write(categoryListJson);
            System.out.println(" ========================== ");
            System.out.println(" ========================== ");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
