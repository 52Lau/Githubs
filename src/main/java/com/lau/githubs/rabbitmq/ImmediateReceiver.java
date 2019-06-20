package com.lau.githubs.rabbitmq;

import com.lau.githubs.common.Constants;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
@EnableRabbit
@Configuration
public class ImmediateReceiver {

    @RabbitListener(queues = Constants.IMMEDIATE_QUEUE)
    @RabbitHandler
    public void get(String msg) {
        System.out.println("收到延时消息了" + msg);
    }
}
