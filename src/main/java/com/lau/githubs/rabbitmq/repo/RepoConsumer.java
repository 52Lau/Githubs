package com.lau.githubs.rabbitmq.repo;

import com.alibaba.fastjson.JSON;
import com.lau.githubs.common.Constants;
import com.lau.githubs.githubspider.GitHubSpider;
import com.lau.githubs.githubspider.dto.GitHubUserRepo;
import com.lau.githubs.mapper.RepoMapper;
import com.lau.githubs.model.Repo;
import com.lau.githubs.model.dto.MsgDTO;
import com.lau.githubs.rabbitmq.config.Config;
import com.lau.githubs.redis.RedisService;
import com.lau.githubs.redis.RepoKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bka
 * @date 2019-06-23 15:51
 */
@Slf4j
@Component
@EnableRabbit
@Configuration
public class RepoConsumer {


    @Resource
    RedisService redisService;
    @Resource
    RepoMapper repoMapper;

    //@RabbitListener(queues = Config.REPO_IMMEDIATE_QUEUE)
    //@RabbitHandler
    public void showMessage(String msg) {
        log.info("收到延时消息了---RepoConsumer:{}" + msg);
        /*MsgDTO msgDTO = JSON.parseObject(msg, MsgDTO.class);
        List<GitHubUserRepo> gitHubUserRepos = GitHubSpider.gen_user_repo_url(msgDTO.getUsername(), msgDTO.getCount());
        List<Repo> repoList = gitHubUserRepos.stream().map(Repo::new).collect(Collectors.toList());
        repoMapper.insertList(repoList);
        redisService.set(new RepoKey("repo_"), msgDTO.getUsername(), repoList);*/

    }
}
