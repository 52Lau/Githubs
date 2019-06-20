package com.lau.githubs.rabbitmq;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lau.githubs.common.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产者生产消息
 */
@Component
public class ImmediateSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg, int delayTime) {
        System.out.println("delayTime" + delayTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.rabbitTemplate.convertAndSend(Constants.DEAD_LETTER_EXCHANGE, Constants.DELAY_ROUTING_KEY, msg, message -> {
            message.getMessageProperties().setExpiration(delayTime + "");
            System.out.println(sdf.format(new Date()) + " Delay sent.");
            return message;
        });
    }
}
