package com.fff.springboot_redis;

import com.fff.springboot_redis.domain.UserInfo;
import com.fff.springboot_redis.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRedisApplication.class)
public class SpringbootRedisApplicationTests {

    @Autowired
    UserMapper userMapper;

//    专门操作字符串的
    @Autowired
    StringRedisTemplate stringRedisTemplate;

//    操作keyvalue键值对的，也就是对象
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        Integer append = stringRedisTemplate.opsForValue().append("b", "aabbbbba");
        System.out.println("append = " + append);

        System.out.println("====================================");

        String a = stringRedisTemplate.opsForValue().get("a");
        System.out.println(a);
    }

    @Test
    public void contextLoads2() {
        UserInfo userInfo = new UserInfo(1,"20","20");
        redisTemplate.opsForValue().set("emp-1",userInfo);

//        1，自己将数据转为string存放

         

    }
}
