package com.lau.githubs.service.impl;

import com.alibaba.fastjson.JSON;
import com.lau.githubs.common.Constants;
import com.lau.githubs.githubspider.GitHubSpider;
import com.lau.githubs.githubspider.dto.GitHubUserInfo;
import com.lau.githubs.model.dto.MsgDTO;
import com.lau.githubs.rabbitmq.ImmediateSender;
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

    @Override
    public void performTask(String userName) {

        System.out.println("username------" + userName);

        GitHubUserInfo gitHubUserInfo = GitHubSpider.gen_user_page_url(userName);
        MsgDTO repoDTO = new MsgDTO(userName, gitHubUserInfo.getPublic_repos());
        MsgDTO followerDTO = new MsgDTO(userName, gitHubUserInfo.getFollowers());
        MsgDTO followingDTO = new MsgDTO(userName, gitHubUserInfo.getFollowing());
        //数据直接下发
        immediateSender.send(JSON.toJSONString(repoDTO), Constants.REPO_EXCHANGE, 10000);
        immediateSender.send(JSON.toJSONString(followerDTO), Constants.FOLLOWER_EXCHANGE, 10000);
        immediateSender.send(JSON.toJSONString(followingDTO), Constants.FOLLOWING_EXCHANGE, 10000);
    }
}
