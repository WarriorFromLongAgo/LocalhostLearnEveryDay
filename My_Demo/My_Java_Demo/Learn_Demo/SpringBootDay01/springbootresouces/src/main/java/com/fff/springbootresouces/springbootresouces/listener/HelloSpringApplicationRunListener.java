package com.fff.springbootresouces.springbootresouces.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.context.event.EventPublishingRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventPublicationInterceptor;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.EventListener;
import java.util.Map;

/**
 * @PackageName：com.fff.springbootresouces.springbootresouces.listener
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/18 20:40
 */
public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {


    public HelloSpringApplicationRunListener(SpringApplication springApplication, String[] args){
        System.out.println("HelloSpringApplicationRunListener....构造器");
        System.out.println("HelloSpringApplicationRunListener....构造器");
        System.out.println("HelloSpringApplicationRunListener....构造器");
    }

    @Override
    public void starting() {
        System.out.println(" HelloSpringApplicationRunListener.......starting");
        System.out.println(" HelloSpringApplicationRunListener.......监听容器的开始");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("HelloSpringApplicationRunListener.....environmentPrepared");
        System.out.println("HelloSpringApplicationRunListener.....环境准备好了");
        for (Map.Entry<String, Object> stringObjectEntry : environment.getSystemEnvironment().entrySet()) {
            System.out.println("environmentPrepared getKey = " + stringObjectEntry.getKey());
            System.out.println("environmentPrepared getValue = " + stringObjectEntry.getValue());
        }

        System.out.println("environment.getPropertySources() = " + environment.getPropertySources());

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener.....contextPrepared");
        System.out.println("IOC容器准备好了。");

        for (Map.Entry<String, Object> stringObjectEntry : context.getEnvironment().getSystemEnvironment().entrySet()) {
            System.out.println("contextPrepared getKey = " + stringObjectEntry.getKey());
            System.out.println("contextPrepared getValue = " + stringObjectEntry.getValue());
        }
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener.....contextLoaded");
        System.out.println("容器环境以及加载完成.........");

        for (Map.Entry<String, Object> stringObjectEntry : context.getEnvironment().getSystemEnvironment().entrySet()) {
            System.out.println("contextLoaded getKey = " + stringObjectEntry.getKey());
            System.out.println("contextLoaded getValue = " + stringObjectEntry.getValue());
        }


    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener.....started");





    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener.....running");


    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("HelloSpringApplicationRunListener.....failed");



    }
}
