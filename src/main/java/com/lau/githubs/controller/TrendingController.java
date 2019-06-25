package com.lau.githubs.controller;

import com.lau.githubs.common.Page;
import com.lau.githubs.model.Hotrepo;
import com.lau.githubs.mq.ImmediateSender;
import com.lau.githubs.service.HotRepoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/trending")
public class TrendingController {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    HotRepoService hotRepoService;

    @Autowired
    ImmediateSender immediateSender;
    @RequestMapping("rabbitmq")
    @ResponseBody
    public String  rabbitmq() {
        immediateSender.send("我是一个延时消息",10000);//3秒
        return "success";
    }

    @RequestMapping("hotRepo")
    @ResponseBody
    public Page  hotRepo() {
        Hotrepo hotrepo=new Hotrepo();
        hotrepo.setLanguages("java");
        hotrepo.setMtype("daily");
        Page page=new Page();
        page.setPageSize(10);
        page.setPageNum(1);
        return hotRepoService.findHotRepo(hotrepo,page);
    }


}
