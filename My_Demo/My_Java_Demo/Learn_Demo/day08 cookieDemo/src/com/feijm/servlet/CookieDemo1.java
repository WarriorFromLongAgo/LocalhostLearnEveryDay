package com.feijm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/cookieDemo1")
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        登陆是否成功
        boolean loginFlag = false;
//        是否含有cookie
        boolean cookieFlag = false;

//        设置请求里面的格式
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
//        获得用户输入的账号
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        PrintWriter printWriter = response.getWriter();
        if ("feijm".equals(userName) && "123".equals(passWord)) {
            loginFlag = true;
        } else {
            printWriter.write("<h1>登录失败</h1>");
        }


//        1，获取所有的cookie
        Cookie[] cookieArr = request.getCookies();
//        必须登陆成功才可以进入
        if (cookieArr != null && cookieArr.length > 0 && (loginFlag)) {
            for (Cookie cookie : cookieArr) {
                String name = cookie.getName();
//                如果存在lastTime，则是第二次登陆
                if ("lastTime".equals(name)) {
                    String value = cookie.getValue();
//                    cookie中含有元素，不是第一次登陆
                    cookieFlag = true;

                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
                    String format = simpleDateFormat.format(date);

//                    URL编码
                    String encode = URLEncoder.encode(format, "utf-8");
                    cookie.setValue(encode);
                    response.addCookie(cookie);

                    String decode = URLDecoder.decode(value, "utf-8");
//                    获取cookie的value
                    printWriter.write("欢迎回来，您上一次的访问时间为：" + decode);
                    break;
                }
            }
        }

        if (cookieArr == null || cookieArr.length == 0 || (!cookieFlag) && (loginFlag)) {

            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
            String format = simpleDateFormat.format(date);
            Cookie cookie = new Cookie("lastTime", format);
            String encode = URLEncoder.encode(format, "utf-8");
            cookie.setValue(encode);
            response.addCookie(cookie);

            printWriter.write("欢迎第一次登陆，" + userName);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
