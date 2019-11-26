package com.fff.test;

import com.fff.domain.UserInfo;
import com.fff.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @PackageName：com.fff.test
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/20 18:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestUserDao {

    @Autowired
    @Qualifier(value = "proxyUserService")
    private IUserService userService;

    @Test
    public void findUserAllServiceTest() {
        List<UserInfo> userInfoList = userService.findUserAllService();
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }
    }
    @Test
    public void updateUserByUserServiceTest() {
        UserInfo userInfo = new UserInfo(4, "ice4", "444");

        int count = userService.updateUserByUserService(userInfo);
        System.out.println(count);
    }
    @Test
    public void insertUserServiceTest() {
        UserInfo userInfo = new UserInfo(5, "ice5", "555");

        int count = userService.insertUserService(userInfo);
        System.out.println(count);
    }
    @Test
    public void deleteUserByIdServiceTest() {
        int count = userService.deleteUserByIdService(5);
        System.out.println(count);
    }
}
