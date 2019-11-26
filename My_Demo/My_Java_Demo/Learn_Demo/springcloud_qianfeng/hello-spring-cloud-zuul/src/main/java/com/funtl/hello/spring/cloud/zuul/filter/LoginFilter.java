package com.funtl.hello.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @PackageName：com.funtl.hello.spring.cloud.zuul.filter
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/23 16:04
 */
@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 配置过滤类型，有四种不同生命周期的过滤器类型
     * 1. pre：路由之前
     * 2. routing：路由之时
     * 3. post：路由之后
     * 4. error：发送错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        //登录前过滤，路由前过滤
        return "pre";
    }

    /**
     * 配置过滤的顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        /*越小越高优先级*/
        return 0;
    }

    /**
     * 配置是否需要过滤：true/需要，false/不需要
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体业务代码
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
//        从zuul请求中获取请求的上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        if (token == null) {
//            logger.warn("Token is empty");
//            不允许访问
            System.out.println("token==null");
            System.out.println("token = " + token);
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
//                响应一个页面数据，告诉访问者
//                http://localhost:9061/api/a/hi?message=springcloud&token=123  判断非空
                HttpServletResponse response = requestContext.getResponse();
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("Token is empty");
            } catch (IOException e) {
            }
        } else {
//            logger.info("OK");
            System.out.println("token!=null");
            System.out.println(token);
        }

        return null;
    }
}
