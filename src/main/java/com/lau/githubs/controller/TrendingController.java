package com.lau.githubs.controller;

import com.lau.githubs.common.Constants;
import com.lau.githubs.model.Hotrepo;
import com.lau.githubs.rabbitmq.ImmediateSender;
import com.lau.githubs.rabbitmq.config.Config;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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








}
