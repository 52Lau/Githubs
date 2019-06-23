package com.lau.githubs.rabbitmq.following;

import com.alibaba.fastjson.JSON;
import com.lau.githubs.common.Constants;
import com.lau.githubs.githubspider.GitHubSpider;
import com.lau.githubs.githubspider.dto.GitHubUserFollowIng;
import com.lau.githubs.model.dto.MsgDTO;
import com.lau.githubs.rabbitmq.ImmediateSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bka
 * @date 2019-06-23 15:52
 */
@Slf4j
@Component
@EnableRabbit
@Configuration
public class FollowingConsumer {

    @Resource
    ImmediateSender immediateSender;

    @RabbitListener(queues = Constants.FOLLOWING_EXCHANGE)
    @RabbitHandler
    public void showMessage(String msg) {
        log.info("收到延时消息了--FollowingConsumer:{}" + msg);
        MsgDTO msgDTO = JSON.parseObject(msg, MsgDTO.class);
        List<GitHubUserFollowIng> gitHubUserFollowIngs = GitHubSpider.gen_user_following_url(msgDTO.getUsername(), msgDTO.getCount());
        if (!CollectionUtils.isEmpty(gitHubUserFollowIngs)) {
            immediateSender.send(JSON.toJSONString(gitHubUserFollowIngs), Constants.USER_EXCHANGE, 10000);
        }
    }
}
