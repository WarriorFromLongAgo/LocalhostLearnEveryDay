package com.fff.springboot_cache;

import com.fff.springboot_cache.domain.UserInfo;
import com.fff.springboot_cache.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootCacheApplication.class)
public class SpringbootCacheApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
        List<UserInfo> userInfoList = userMapper.findAllUserInfoAnnoMapper();

        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }

    }

}
