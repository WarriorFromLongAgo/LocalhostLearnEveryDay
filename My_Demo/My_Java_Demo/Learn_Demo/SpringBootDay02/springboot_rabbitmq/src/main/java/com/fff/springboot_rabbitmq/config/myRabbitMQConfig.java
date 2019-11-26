package com.fff.springboot_rabbitmq.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PackageName：com.fff.springboot_rabbitmq.config
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/20 9:17
 */
@Configuration
public class myRabbitMQConfig {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();

    }

}
