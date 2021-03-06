package com.lau.githubs.service.impl;

import com.alibaba.fastjson.JSON;
import com.lau.githubs.common.Constants;
import com.lau.githubs.githubspider.GitHubSpider;
import com.lau.githubs.githubspider.dto.GitHubUserInfo;
import com.lau.githubs.mapper.UserMapper;
import com.lau.githubs.model.User;
import com.lau.githubs.model.dto.MsgDTO;
import com.lau.githubs.rabbitmq.ImmediateSender;
import com.lau.githubs.rabbitmq.config.Config;
import com.lau.githubs.redis.RedisService;
import com.lau.githubs.redis.RepoKey;
import com.lau.githubs.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author bka
 * @date 2019-06-23 15:47
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    ImmediateSender immediateSender;

    @Resource
    RedisService redisService;

    @Resource
    UserMapper userMapper;

    @Override
    public void performTask(String userName) {

        System.out.println("username------" + userName);

        GitHubUserInfo gitHubUserInfo = GitHubSpider.gen_user_page_url(userName);
        userMapper.insert(new User(gitHubUserInfo));
        redisService.set(new RepoKey("user_"), gitHubUserInfo.getLogin(), gitHubUserInfo);
        MsgDTO repoDTO = new MsgDTO(userName, gitHubUserInfo.getPublic_repos());
        MsgDTO followerDTO = new MsgDTO(userName, gitHubUserInfo.getFollowers());
        MsgDTO followingDTO = new MsgDTO(userName, gitHubUserInfo.getFollowing());
        //数据直接下发
        //to_do
        immediateSender.send(JSON.toJSONString(repoDTO), Config.REPO_DEAD_LETTER_EXCHANGE, Config.REPO_DELAY_ROUTING_KEY, 10000);
        immediateSender.send(JSON.toJSONString(followerDTO), Config.FOLLOWER_DEAD_LETTER_EXCHANGE, Config.FOLLOWER_DELAY_ROUTING_KEY, 10000);
        immediateSender.send(JSON.toJSONString(followingDTO), Config.FOLLOWING_DEAD_LETTER_EXCHANGE, Config.FOLLOWING_DELAY_ROUTING_KEY, 10000);
    }
}
