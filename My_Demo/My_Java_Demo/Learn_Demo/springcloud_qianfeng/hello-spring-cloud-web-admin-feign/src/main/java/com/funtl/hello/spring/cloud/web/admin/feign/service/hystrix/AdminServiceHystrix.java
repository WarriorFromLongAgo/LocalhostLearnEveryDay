package com.funtl.hello.spring.cloud.web.admin.feign.service.hystrix;

import com.funtl.hello.spring.cloud.web.admin.feign.service.AdminService;
import org.springframework.stereotype.Component;

/**
 * @PackageName：com.funtl.hello.spring.cloud.web.admin.feign.service.hystrix
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/23 11:05
 */
@Component
public class AdminServiceHystrix implements AdminService {
    @Override
    public String sayHi(String message) {
        return "Hi，your message is :\"" + message + "\" but request error.";
    }
}
