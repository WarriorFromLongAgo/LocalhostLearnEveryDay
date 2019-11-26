package com.fff.thymeleaf1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @PackageName：com.fff.thymeleaf1.config
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/16 18:35
 */
@EnableWebMvc
@Configuration
public class MySpringMvc implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        请求是 hello2 会自动的跳转到 success
        registry.addViewController("/hello2").setViewName("/success");
    }
}
