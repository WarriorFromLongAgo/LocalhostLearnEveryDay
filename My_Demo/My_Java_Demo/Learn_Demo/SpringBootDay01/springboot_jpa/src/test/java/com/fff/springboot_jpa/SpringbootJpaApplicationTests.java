package com.fff.springboot_jpa;

import com.fff.SpringbootJpaApplication;
import com.fff.domain.UserInfo;
import com.fff.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class SpringbootJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAllUserInfoRepository() {
        List<UserInfo> userInfoList = userRepository.findAll();

        System.out.println("daskjhdjaskhdasjkhdjkashfjkdshfsdjksdjkfhs");
        System.out.println("daskjhdjaskhdasjkhdjkashfjkdshfsdjksdjkfhs");
        System.out.println("daskjhdjaskhdasjkhdjkashfjkdshfsdjksdjkfhs");
        System.out.println("daskjhdjaskhdasjkhdjkashfjkdshfsdjksdjkfhs");
        System.out.println(userInfoList);


    }

}
