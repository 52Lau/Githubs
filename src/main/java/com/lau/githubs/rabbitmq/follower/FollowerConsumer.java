package com.lau.githubs.rabbitmq.follower;

import com.alibaba.fastjson.JSON;
import com.lau.githubs.common.Constants;
import com.lau.githubs.githubspider.GitHubSpider;
import com.lau.githubs.githubspider.dto.GitHubUserFollower;
import com.lau.githubs.model.dto.MsgDTO;
import com.lau.githubs.rabbitmq.ImmediateSender;
import com.lau.githubs.rabbitmq.config.Config;
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
public class FollowerConsumer {

    @Resource
    ImmediateSender immediateSender;

    @RabbitListener(queues = Config.FOLLOWER_IMMEDIATE_QUEUE)
    @RabbitHandler
    public void showMessage(String msg) {
        log.info("收到延时消息了---FollowerConsumer:{}", msg);
        /*MsgDTO msgDTO = JSON.parseObject(msg, MsgDTO.class);
        List<GitHubUserFollower> gitHubUserFollowers = GitHubSpider.gen_user_follwer_url(msgDTO.getUsername(), msgDTO.getCount());
        if (!CollectionUtils.isEmpty(gitHubUserFollowers)) {
            gitHubUserFollowers.forEach(gitHubUserFollower -> immediateSender.send(JSON.toJSONString(gitHubUserFollower.getLogin()), Config.FOLLOWER_DEAD_LETTER_EXCHANGE, Config.FOLLOWER_DELAY_ROUTING_KEY, 10000));
        }*/
    }
}
