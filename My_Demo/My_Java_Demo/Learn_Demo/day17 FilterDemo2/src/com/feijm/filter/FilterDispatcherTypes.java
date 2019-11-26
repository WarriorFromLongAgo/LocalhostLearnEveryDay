package com.feijm.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


//@WebFilter(urlPatterns = "/index.jsp", dispatcherTypes = DispatcherType.REQUEST)
//@WebFilter(urlPatterns = "/index.jsp", dispatcherTypes = DispatcherType.FORWARD)
//@WebFilter(urlPatterns = "/index.jsp", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
@WebFilter(urlPatterns = "/*", dispatcherTypes = DispatcherType.REQUEST)
public class FilterDispatcherTypes implements Filter {
    @Override
    public void destroy() {
        System.out.println("FilterDispatcherTypes");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("FilterDispatcherTypes.................");
        System.out.println(((HttpServletRequest) req).getRequestURI());
        System.out.println("++++++++++");
        chain.doFilter(req, resp);
    }


    @Override
    public void init(FilterConfig config) throws ServletException {
        String filterName = config.getFilterName();
        System.out.println("初始化执行 = " + filterName);
    }

}
