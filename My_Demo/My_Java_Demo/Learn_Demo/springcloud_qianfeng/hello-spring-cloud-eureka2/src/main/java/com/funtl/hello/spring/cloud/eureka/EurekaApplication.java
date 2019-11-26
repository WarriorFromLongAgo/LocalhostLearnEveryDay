package com.funtl.hello.spring.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @PackageName：com.funtl.hello.spring.cloud.eureka
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/22 19:22
 */
/*说明是个springboot项目*/
@SpringBootApplication
/*开始eureka服务*/
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
