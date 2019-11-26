package com.fff.test;

import com.fff.domain.UserInfo;
import com.fff.service.IUserService;
import config.ApplicationConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @PackageName：com.fff.test
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/20 22:17
 */
public class TestUserService {
    @Test
    public void findUserAllDaoTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        List<UserInfo> userInfoList = userService.findUserAllService();
        for (UserInfo userInfo : userInfoList) {

            System.out.println(userInfo);
        }
    }
}
