package com.fff.springbootresouces.springbootresouces.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @PackageName：com.fff.springbootresouces.springbootresouces.listener
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/18 20:35
 */
public class HelloApplicationContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("HelloApplicationContextInitializer....initialize....configurableApplicationContext");
        System.out.println("configurableApplicationContext = "+configurableApplicationContext);

    }
}
