package com.lau.githubs.controller;

import com.lau.githubs.common.Constants;
import com.lau.githubs.model.Hotrepo;
import com.lau.githubs.rabbitmq.ImmediateSender;
import com.lau.githubs.rabbitmq.config.Config;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.sun.tools.doclint.Entity.trade;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/trending")
public class TrendingController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ImmediateSender immediateSender;

    @GetMapping("send")
    public String sendmsg(){
        try {
            immediateSender.send("我是一个1延时消息，睡10秒",Config.DEAD_LETTER_EXCHANGE, Config.DELAY_ROUTING_KEY,10000);//10秒
            immediateSender.send("我是一个2延时消息，睡10秒",Config.USER_DEAD_LETTER_EXCHANGE, Config.USER_DELAY_ROUTING_KEY,10000);//10秒
            immediateSender.send("我是一个3延时消息，睡10秒",Config.REPO_DEAD_LETTER_EXCHANGE, Config.REPO_DELAY_ROUTING_KEY,10000);//10秒
            immediateSender.send("我是一个4延时消息，睡10秒",Config.FOLLOWER_DEAD_LETTER_EXCHANGE, Config.FOLLOWER_DELAY_ROUTING_KEY,10000);//10秒
            immediateSender.send("我是一个5延时消息，睡10秒",Config.FOLLOWING_DEAD_LETTER_EXCHANGE, Config.FOLLOWING_DELAY_ROUTING_KEY,10000);//10秒
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }





}
