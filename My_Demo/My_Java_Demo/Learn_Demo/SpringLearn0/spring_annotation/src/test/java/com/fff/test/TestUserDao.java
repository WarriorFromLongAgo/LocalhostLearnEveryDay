package com.fff.test;

import com.fff.domain.UserInfo;
import com.fff.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @PackageName：com.fff.test
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/20 19:40
 */
public class TestUserDao {

    @Test
    public void findUserAllDaoTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        List<UserInfo> userInfoList = userService.findUserAllService();
        for (UserInfo userInfo : userInfoList) {

            System.out.println(userInfo);
        }
    }
}
