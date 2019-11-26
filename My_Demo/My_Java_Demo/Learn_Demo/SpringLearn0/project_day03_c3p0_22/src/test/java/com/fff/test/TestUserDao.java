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
 * @date：2019/10/20 18:43
 */
public class TestUserDao {

    @Test
    public void findUserAllServiceTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);

        List<UserInfo> userInfoList = userService.findUserAllService();
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }
    }
    @Test
    public void updateUserByUserServiceTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);

        UserInfo userInfo = new UserInfo(4, "ice4", "444");

        int count = userService.updateUserByUserService(userInfo);
        System.out.println(count);
    }
    @Test
    public void insertUserServiceTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);

        UserInfo userInfo = new UserInfo(5, "ice5", "555");

        int count = userService.insertUserService(userInfo);
        System.out.println(count);
    }
    @Test
    public void deleteUserByIdServiceTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);

        int count = userService.deleteUserByIdService(5);
        System.out.println(count);
    }
}
