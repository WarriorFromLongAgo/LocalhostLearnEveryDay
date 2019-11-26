package com.feijm.xiangmu001.web.newservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feijm.xiangmu001.domain.ResultInfo;
import com.feijm.xiangmu001.domain.UserInfo;
import com.feijm.xiangmu001.service.IUserService;
import com.feijm.xiangmu001.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(urlPatterns = "/user/*")
public class UserServlet extends BaseServlet {
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkCodeServer = (String) session.getAttribute("CHECKCODE_SERVER");

        session.removeAttribute("CHECKCODE_SERVER");

        if (checkCodeServer == null || !checkCodeServer.equalsIgnoreCase(check)) {
            System.out.println("checkCodeServer = " + checkCodeServer);
            System.out.println("check = " + check);
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误");

            ObjectMapper objectMapper = new ObjectMapper();
            String resultInfoStr = objectMapper.writeValueAsString(resultInfo);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(resultInfoStr);
            return;
        }

        //        1，获取数据
        String userName = request.getParameter("username");
        System.out.println(userName);
        String passWord = request.getParameter("password");
        System.out.println(passWord);

//        3，调用service完成注册
        IUserService userService = new UserServiceImpl();
        UserInfo userByLogin = userService.loginService(userName, passWord);
        System.out.println(userByLogin);
        ResultInfo resultInfo = new ResultInfo();

//        4，响应结果
        if (userByLogin != null) {
//            成功不需要添加一些信息，或者错误的数据
            if ("1".equals(userByLogin.getStatus())) {
                session.setAttribute("user", userByLogin);
                resultInfo.setFlag(true);
            } else {
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("登录失败！，请先激活再登录");
            }
        } else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("登录失败！，请输入正确的账号和密码");
        }

//        将这个 resultInfo 对象序列化成json，并且输出到页面上
        ObjectMapper objectMapper = new ObjectMapper();
        String resultInfoStr = objectMapper.writeValueAsString(resultInfo);
        response.setContentType("application/json;charset=utf-8");
        System.out.println(" ========================== ");
        System.out.println(" ========================== ");

        response.getWriter().write(resultInfoStr);

    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        验证码验证
//        获取前台验证码
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkCodeServer = (String) session.getAttribute("CHECKCODE_SERVER");
//        为了保证验证码只能使用一次
        session.removeAttribute("CHECKCODE_SERVER");

        if (checkCodeServer == null || !checkCodeServer.equalsIgnoreCase(check)) {
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误！");

            ObjectMapper objectMapper = new ObjectMapper();
            String resultInfoStr = objectMapper.writeValueAsString(resultInfo);
            response.setContentType("application/json;charset=utf-8");

            response.getWriter().write(resultInfoStr);
            System.out.println(" ========================== ");
            System.out.println(" ========================== ");

            return;
        }

//        1，获取数据
        Map<String, String[]> parameterMap = request.getParameterMap();
//        2，封装对象
        UserInfo userInfo = new UserInfo();
        try {
            BeanUtils.populate(userInfo, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        3，调用service完成注册
        IUserService userService = new UserServiceImpl();
        boolean registerFlag = userService.registerService(userInfo);
        ResultInfo resultInfo = new ResultInfo();
//        4，响应结果
        if (registerFlag) {
//            成功不需要添加一些信息，或者错误的数据
            resultInfo.setFlag(true);
        } else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败！");
        }

//        将这个 resultInfo 对象序列化成json，并且输出到页面上
        ObjectMapper objectMapper = new ObjectMapper();
        String resultInfoStr = objectMapper.writeValueAsString(resultInfo);
        response.setContentType("application/json;charset=utf-8");
        System.out.println(" ========================== ");
        System.out.println(" ========================== ");

        response.getWriter().write(resultInfoStr);

    }

    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        System.out.println(code);

        IUserService userService = new UserServiceImpl();
        boolean activeFlag = userService.activeService(code);

        String message = null;
        if (activeFlag) {
            System.out.println("11111111");
            message = "激活成功：<a href='" + request.getContextPath() + "/login.html'>点击跳转页面</a>";
        } else {
            System.out.println("0000000");
            message = "验证码错误，请联系管理员";
        }
        response.setContentType("text/html;charset=utf-8");
        System.out.println(" ========================== ");
        System.out.println(" ========================== ");

        response.getWriter().write(message);
//        response.sendRedirect(request.getContextPath() + "/isactive.html");

    }

    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/index.html");
    }

    public void findLoginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object user = request.getSession().getAttribute("user");

        ObjectMapper objectMapper = new ObjectMapper();
        String userStrJson = objectMapper.writeValueAsString(user);
        response.setContentType("application/json;charset=utf-8");
        System.out.println(" ========================== ");
        System.out.println(" ========================== ");

        response.getWriter().write(userStrJson);

    }
}
