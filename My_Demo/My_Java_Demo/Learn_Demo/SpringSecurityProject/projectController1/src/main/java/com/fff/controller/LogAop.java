package com.fff.controller;

import com.fff.domain.SysLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.security.util.SecurityConstants;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/14 17:14
 */
@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    /*
    * controller必须使用对象类型，否则会找不到
    *
    * */
    //    访问开始时间
    private Date startTime;
    //    访问的类
    private Class visitClass;
    //    访问的方法
    private Method visitMethod;

    @Before("execution(* com.fff.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
//        获取访问时间
        startTime = new Date();
//        获取访问的类
        visitClass = joinPoint.getTarget().getClass();
//        获取访问方法的名称
        String visitMethodName = joinPoint.getSignature().getName();
//        获取访问方法的参数
        Object[] args = joinPoint.getArgs();
//        当为请求的无参方法时
        if (args == null || args.length == 0) {
//            获取无参方法
            visitMethod = visitClass.getMethod(visitMethodName);
        } else {
//            创建一个方法参数长度的数据，里面包含的都是类
            Class[] classArgs = new Class[args.length];
//            遍历数组，将类都放到数组里面
            for (int i = 0; i < classArgs.length; i++) {
                classArgs[i] = args[i].getClass();
            }
//            获取请求的方法，对应数量参数的
            visitMethod = visitClass.getMethod(visitMethodName, classArgs);

        }

    }

    @After("execution(* com.fff.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) {
//        获取requestMapping对象
        if (visitClass != SysLog.class) {
//            获取类上的 RequestMapping 注解
            RequestMapping classRequestMapping = (RequestMapping) visitClass.getAnnotation(RequestMapping.class);
            if (classRequestMapping != null) {
//                获取方法上的 RequestMapping 注解
                RequestMapping methodRequestMapping = visitMethod.getAnnotation(RequestMapping.class);
                if (methodRequestMapping != null) {
                    String requestUrl = "";
                    requestUrl = classRequestMapping.value()[0] + methodRequestMapping.value()[0];

//                    获取访问时长
                    long visitTime = new Date().getTime() - startTime.getTime();

                    SysLog sysLog = new SysLog();

                    sysLog.setVisitTime(startTime);
                    sysLog.setExecutionTime(visitTime);
                    sysLog.setUrl(requestUrl);

                    String addr = request.getRemoteAddr();
                    sysLog.setIp(addr);

                    SecurityContext securityContext = SecurityContextHolder.getContext();
//                    User user = (User)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
                    String userName = ((User) securityContext.getAuthentication().getPrincipal()).getUsername();
                    sysLog.setUserName(userName);

                    sysLog.setMethod("[类名]" + visitClass.getName() + "[方法名]" + visitMethod.getName());



                }

            }

        }

    }


}
