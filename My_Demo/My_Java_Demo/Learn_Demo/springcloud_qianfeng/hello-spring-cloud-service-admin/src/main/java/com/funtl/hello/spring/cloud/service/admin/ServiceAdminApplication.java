package com.funtl.hello.spring.cloud.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @PackageName：com.funtl.hello.spring.cloud.service.admin
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/22 20:12
 */
/*是个springboot程序*/
@SpringBootApplication
/*eureka开启客户端*/
@EnableEurekaClient
public class ServiceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAdminApplication.class, args);
    }

}
