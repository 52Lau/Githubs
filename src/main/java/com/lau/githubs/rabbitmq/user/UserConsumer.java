package com.lau.githubs.rabbitmq.user;

import com.lau.githubs.common.Constants;
import com.lau.githubs.rabbitmq.config.Config;
import com.lau.githubs.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @author bka
 * @date 2019-06-23 15:51
 */
@Slf4j
@Component
@EnableRabbit
@Configuration
public class UserConsumer {

    @Resource
    UserService userService;

    //@RabbitListener(queues = Config.USER_IMMEDIATE_QUEUE)
    //@RabbitHandler
    public void showMessage(String msg) {
        log.info("收到延时消息了---UserConsumer:{}" + msg);
        /*userService.performTask(msg);*/
    }
}
