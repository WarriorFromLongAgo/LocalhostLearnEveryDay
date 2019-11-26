package com.feijm.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/request1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * 1，获取请求的方式，get post
					String getMethod()

				2，(重要)获取虚拟目录		/day14
					String getContextPath()

				3，获取servlet路径，	/demo1
	 				String getServletPath()

				4，获取get方式请求参数 name=zhangsan
					String getQueryString

				5，(重要)获取请求的URI		/day14/demo1
					String getRequestURI()	/day14/demo1
					StringBuffer getRequestURL()	http://localhost/day14/demo1

				6，获取协议及版本	http/1.1
					String getProtocol()

				7，获取客户机的IP地址
					String getRemoteAddr()
        * */
        //  获取请求方式
        String method = request.getMethod();
        System.out.println("method = " + method);
        System.out.println("=============================================");
        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);
        System.out.println("=============================================");
        String servletPath = request.getServletPath();
        System.out.println("servletPath = " + servletPath);
        System.out.println("=============================================");
        String queryString = request.getQueryString();
        System.out.println("queryString = " + queryString);
        System.out.println("=============================================");
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURI = " + requestURI);
        System.out.println("requestURL = " + requestURL);
        System.out.println("=============================================");
        String protocol = request.getProtocol();
        System.out.println("protocol = " + protocol);
        System.out.println("=============================================");
        String remoteAddr = request.getRemoteAddr();
        System.out.println("remoteAddr = " + remoteAddr);
    }
}
