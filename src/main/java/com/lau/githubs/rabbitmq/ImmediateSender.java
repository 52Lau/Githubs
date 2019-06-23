package com.lau.githubs.rabbitmq;


import com.lau.githubs.common.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * 生产者生产消息
 */
@Component
public class ImmediateSender {

    private final RabbitTemplate rabbitTemplate;

    public ImmediateSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String msg, String exchange, int delayTime) {
        this.rabbitTemplate.convertAndSend(exchange, msg, message -> {
            message.getMessageProperties().setExpiration(delayTime + "");
            return message;
        });
    }
}
