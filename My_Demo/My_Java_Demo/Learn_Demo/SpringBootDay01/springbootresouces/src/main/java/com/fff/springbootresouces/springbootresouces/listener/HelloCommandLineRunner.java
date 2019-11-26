package com.fff.springbootresouces.springbootresouces.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @PackageName：com.fff.springbootresouces.springbootresouces.listener
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/18 20:52
 */
@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("HelloCommandLineRunner........run");

        System.out.println("=========================================");
        for (String arg : args) {
            System.out.println(arg);
        }
        System.out.println("=========================================");


    }
}
