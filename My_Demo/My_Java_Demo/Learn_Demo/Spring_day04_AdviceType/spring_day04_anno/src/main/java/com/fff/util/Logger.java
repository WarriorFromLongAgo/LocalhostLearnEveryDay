package com.fff.util;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @PackageName：com.fff.util
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/21 18:44
 */
@Component(value = "logger")
@Aspect
public class Logger {

    public void printLog() {
        System.out.println("printLog");
    }
}
