package com.fff.springbootresouces.springbootresouces.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @PackageName：com.fff.springbootresouces.springbootresouces.listener
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/18 20:49
 */
@Component
public class HelloApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("HelloApplicationRunner.....run");
        for (String s : args.getNonOptionArgs()) {
            System.out.println(s);
        }
        System.out.println("========================================================");
        for (String s : args.getOptionNames()) {
            System.out.println(s);
        }
        System.out.println("========================================================");
        for (String s : args.getSourceArgs()) {
            System.out.println(s);
        }
        System.out.println("========================================================");


    }
}
