package com.fff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @PackageName：com.fff.controller
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/3 21:57
 */
@EnableWebMvc
@EnableSwagger2                         /* 使 Swagger2 生效*/
@Configuration                          /*自动在本类上下文加载一些环境变量信息*/
@ComponentScan("com.fff.controller")    /*设置 Swagger 扫描包：*/
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                /*api信息 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）*/
                .apiInfo(getApiInfo())
                /*扫描哪个路径的哪些api  设置哪些接口暴露给Swagger展示*/
                .select()
                /* apis()：要展示的API apis()*/
                /* RequestHandlerSelectors.any() 任何路径*/
                /* RequestHandlerSelectors.basePackage("com.fff.*") 包位置*/
                /* RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class) 类位置*/
                .apis(RequestHandlerSelectors.any())
                /* paths()：要展示的路径*/
                /* PathSelectors.any()：任何路径都可以*/
                .paths(PathSelectors.any())
                /* Docker build()：创建Docker对象*/
                .build();
    }

    private ApiInfo getApiInfo() {
        /* 自定义该API工具展示信息，标题、描述、更新的地址、作者信息、版本等 **/
        return new ApiInfoBuilder()
                /* 设置标题*/
                .title("SSM1 博客发布项目")
                /* description(String str): 描述*/
                /* termsOfServiceUrl(String str): 更新地址*/
                /* 作者信息*/
                .contact(new Contact("name", "url", "联系方式"))
                .version("1.0.0")
                .build();
    }


}
