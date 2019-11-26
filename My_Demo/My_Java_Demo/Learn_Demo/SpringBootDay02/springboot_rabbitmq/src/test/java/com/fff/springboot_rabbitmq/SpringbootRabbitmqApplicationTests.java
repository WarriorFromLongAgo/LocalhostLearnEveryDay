package com.fff.springboot_rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRabbitmqApplication.class)
public class SpringbootRabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        //Message需要自己构造一个;定义消息体内容和清息头
        //rabbitTemplate.send(exchage, routeKey, message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq;
        //rabbitTemplate. convertAndSend( exchage, routeKey,object);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "这是第一个消息");
        map.put("date", "helloWorld");

//        rabbitTemplate.convertAndSend(".direct", "", map);
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", map);
    }

    /**/
    @Test
    public void test2(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     * */
    @Test
    public void text3(){
        Map<String, Object> map2 = new HashMap<>();
        map2.put("boot", "boooooooooooooooooooooooooooooooooooooooot");
        rabbitTemplate.convertAndSend("exchange.fanout","",map2);
    }

}
