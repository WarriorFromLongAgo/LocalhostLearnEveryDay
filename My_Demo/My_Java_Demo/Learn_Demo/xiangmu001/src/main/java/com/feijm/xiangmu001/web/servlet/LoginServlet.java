//package com.feijm.xiangmu001.web.servlet;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.feijm.xiangmu001.domain.ResultInfo;
//import com.feijm.xiangmu001.domain.UserInfo;
//import com.feijm.xiangmu001.service.IUserService;
//import com.feijm.xiangmu001.service.impl.UserServiceImpl;
//import org.apache.commons.beanutils.BeanUtils;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.Map;
//
//@WebServlet(urlPatterns = "/loginServlet")
//public class LoginServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String check = request.getParameter("check");
//        HttpSession session = request.getSession();
//        String checkCodeServer = (String) session.getAttribute("CHECKCODE_SERVER");
//
//        session.removeAttribute("CHECKCODE_SERVER");
//
//        if (checkCodeServer == null || !checkCodeServer.equalsIgnoreCase(check)) {
//            System.out.println("checkCodeServer = " + checkCodeServer);
//            System.out.println("check = " + check);
//            ResultInfo resultInfo = new ResultInfo();
//            resultInfo.setFlag(false);
//            resultInfo.setErrorMsg("验证码错误");
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            String resultInfoStr = objectMapper.writeValueAsString(resultInfo);
//            response.setContentType("application/json;charset=utf-8");
//            response.getWriter().write(resultInfoStr);
//            return;
//        }
//
//        //        1，获取数据
//        String userName = request.getParameter("username");
//        System.out.println(userName);
//        String passWord = request.getParameter("password");
//        System.out.println(passWord);
//
////        3，调用service完成注册
//        IUserService userService = new UserServiceImpl();
//        UserInfo userByLogin = userService.loginService(userName, passWord);
//        System.out.println(userByLogin);
//        ResultInfo resultInfo = new ResultInfo();
//
////        4，响应结果
//        if (userByLogin != null) {
////            成功不需要添加一些信息，或者错误的数据
//            if ("1".equals(userByLogin.getStatus())) {
//                session.setAttribute("user", userByLogin);
//                resultInfo.setFlag(true);
//            } else {
//                resultInfo.setFlag(false);
//                resultInfo.setErrorMsg("登录失败！，请先激活再登录");
//            }
//        } else {
//            resultInfo.setFlag(false);
//            resultInfo.setErrorMsg("登录失败！，请输入正确的账号和密码");
//        }
//
////        将这个 resultInfo 对象序列化成json，并且输出到页面上
//        ObjectMapper objectMapper = new ObjectMapper();
//        String resultInfoStr = objectMapper.writeValueAsString(resultInfo);
//        response.setContentType("application/json;charset=utf-8");
//        response.getWriter().write(resultInfoStr);
//
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
//}
