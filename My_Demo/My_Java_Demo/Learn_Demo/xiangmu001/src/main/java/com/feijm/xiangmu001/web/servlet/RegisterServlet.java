//package com.feijm.xiangmu001.web.servlet;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
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
//@WebServlet(urlPatterns = "/registerServlet")
//public class RegisterServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        验证码验证
////        获取前台验证码
//        String check = request.getParameter("check");
//        HttpSession session = request.getSession();
//        String checkCodeServer = (String) session.getAttribute("CHECKCODE_SERVER");
////        为了保证验证码只能使用一次
//        session.removeAttribute("CHECKCODE_SERVER");
//
//        if (checkCodeServer == null || !checkCodeServer.equalsIgnoreCase(check)) {
//            ResultInfo resultInfo = new ResultInfo();
//            resultInfo.setFlag(false);
//            resultInfo.setErrorMsg("验证码错误！");
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            String resultInfoStr = objectMapper.writeValueAsString(resultInfo);
//            response.setContentType("application/json;charset=utf-8");
//            response.getWriter().write(resultInfoStr);
//            return;
//        }
//
////        1，获取数据
//        Map<String, String[]> parameterMap = request.getParameterMap();
////        2，封装对象
//        UserInfo userInfo = new UserInfo();
//        try {
//            BeanUtils.populate(userInfo, parameterMap);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
////        3，调用service完成注册
//        IUserService userService = new UserServiceImpl();
//        boolean registerFlag = userService.registerService(userInfo);
//        ResultInfo resultInfo = new ResultInfo();
////        4，响应结果
//        if (registerFlag) {
////            成功不需要添加一些信息，或者错误的数据
//            resultInfo.setFlag(true);
//        } else {
//            resultInfo.setFlag(false);
//            resultInfo.setErrorMsg("注册失败！");
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
