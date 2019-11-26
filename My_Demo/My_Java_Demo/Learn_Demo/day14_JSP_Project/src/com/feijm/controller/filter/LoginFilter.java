package com.feijm.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
 * 验证登录验证的过滤器
 *
 * */
@WebFilter(urlPatterns = "/*", dispatcherTypes = DispatcherType.REQUEST)
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        获取资源的请求路径
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        System.out.println("URI = " + httpServletRequest.getRequestURI());
        System.out.println("URL = " + httpServletRequest.getRequestURL());

        String requestURI = httpServletRequest.getRequestURI();
        if (requestURI.contains("index.jsp") || requestURI.contains("loginController") || requestURI.contains("/css/") || requestURI.contains("/js/") || requestURI.contains("/fonts/") || requestURI.contains("/checkCodeServlet")) {
//            包含就是想登录就直接放行
            filterChain.doFilter(request, response);
        } else {
//            从session中获取用户是否登录
            Object userAccount = httpServletRequest.getSession().getAttribute("userAccount");

//            登录了就放行
            if (userAccount != null) {
                filterChain.doFilter(request, response);
            } else {
//                没有登录，就跳转到登录页面
                request.setAttribute("errorInfo", "您尚未登录，请登录");
                request.getRequestDispatcher("index.jsp").forward(httpServletRequest, response);
            }

        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

}
