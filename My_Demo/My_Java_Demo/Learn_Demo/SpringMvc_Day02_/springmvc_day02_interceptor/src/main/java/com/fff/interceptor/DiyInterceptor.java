package com.fff.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @PackageName：com.fff
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/27 11:59
 */
public class DiyInterceptor implements HandlerInterceptor {


    @Override
    /**
     * @Title: 预处理的方法
     * @MethodName: preHandle
     * @param request :
     * @param response :
     * @param handler :

     * @Return boolean
     * @Description: 预处理：在controller执行前
     * @Description: 返回true放行，执行下一个拦截器，如果没有则执行拦截器中的方法
     * @Description: 返回false不放行，跳转到某某页面
     * @author: 作者名
     * @date: 2019/10/27 12:17
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(" 拦截器执行了。 ");
        return true;
    }


    @Override
    /**
     * @Title:  后处理的方法
     * @MethodName: postHandle
     * @param request :
     * @param response :
     * @param handler :
     * @param modelAndView :

     * @Return void
     * @Description:    controller执行后，success.jsp执行前，执行该方法
     * @Description:
     * @Description:
     * @author: 作者名
     * @date: 2019/10/27 12:46
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println(" postHandle 执行 ");
    }
}
