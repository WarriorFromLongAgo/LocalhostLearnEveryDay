package com.fff.springboot_mybatis;

import com.fff.SpringbootMybatisApplication;
import com.fff.domain.UserInfo;
import com.fff.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class SpringbootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAllUserInfoMapper() {
        List<UserInfo> userInfoList = userMapper.findAllUserInfoMapper();
        System.out.println(userInfoList);
    }

}
