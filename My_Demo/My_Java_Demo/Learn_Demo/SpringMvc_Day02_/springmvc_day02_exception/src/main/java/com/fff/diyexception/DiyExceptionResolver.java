package com.fff.diyexception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @PackageName：com.fff.diyexception
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/26 22:34
 */
public class DiyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object o, Exception e) {
        DiyException diyException = null;
        if (e instanceof DiyException) {
            diyException = (DiyException) e;
        } else {
            diyException = new DiyException(" 系统正在维护。。。 ");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", diyException.getMessage());

        modelAndView.setViewName("error");

        return modelAndView;
    }
}
