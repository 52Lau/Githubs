package com.lau.githubs.githubspider;

import com.alibaba.fastjson.JSON;
import com.lau.githubs.githubspider.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GitHubSpider {

    private static final Logger log = LoggerFactory.getLogger(GitHubSpider.class);

    static HashMap<String, String > headers = new HashMap<String, String>(){{
        put("User-Agent","Mozilla/5.0");
        put("Authorization","token bbaf0857b543362f3bc7c52356e5ee51ff06e0e0");
        put("Content-Type","application/json");
        put("Accept","application/vnd.github.v3+json");
    }};


    /**
     * 获取用户主页
     * @param username 用户名
     * @return
     */
    public static GitHubUserInfo gen_user_page_url(String username){
        String jsonStr = sendGet("https://api.github.com/users/"+username, headers);
        GitHubUserInfo gitHubUserInfo = JSON.parseObject(jsonStr, GitHubUserInfo.class);
        return gitHubUserInfo;
    }

    /**
     * 获取用户粉丝列表
     * @param username
     * @param page
     * @return
     */
    public static List<GitHubUserFollower> gen_user_follwer_url(String username, Integer page){
        List<GitHubUserFollower> followerLists = new ArrayList<>();
        List<GitHubUserFollower> followerList = new ArrayList<>();

        double a=page;
        Integer b=(int)Math.ceil(a/30);

        try {
            for (int i = 1; i <= b; i++) {
                String jsonStr = sendGet("https://api.github.com/users/"+username+"/followers?page="+i, headers);
                followerList = JSON.parseArray(jsonStr, GitHubUserFollower.class);
                followerList.forEach(v->{
                    followerLists.add(v);
                });
            }
        } catch (Exception e) {
            log.error("用户名不存在或者请求被限制");
            e.printStackTrace();
        }
        return followerLists;
    }

    /**
     * 获取用户关注用户列表
     * @param username
     * @param page
     * @return
     */
    public static List<GitHubUserFollowIng> gen_user_following_url(String username, Integer page){
        List<GitHubUserFollowIng> followIngLists = null;
        List<GitHubUserFollowIng> followIngList = null;
        double a=page;
        Integer b=(int)Math.ceil(a/30);

        try {
            for (int i = 1; i <= b; i++) {
                //String jsonStr = HttpUtil.get("https://api.github.com/users/"+username+"/following?page=" + page, headers);
                String jsonStr = sendGet("https://api.github.com/users/"+username+"/following?page=" + i, headers);
                followIngList = JSON.parseArray(jsonStr, GitHubUserFollowIng.class);
                /*followIngList.forEach(v->{
                    followIngLists.add(v);
                });*/
            }
        } catch (Exception e) {
            log.error("用户名不存在或者请求被限制");
            e.printStackTrace();
        }

        return followIngLists;
    }

    /**
     * 获取用户项目列表
     * @param username
     * @param page
     * @return
     */
    public static List<GitHubUserRepo> gen_user_repo_url(String username, Integer page){
        List<GitHubUserRepo> repoLists = null;
        List<GitHubUserRepo> repoList = new ArrayList<>();
        double a=page;
        Integer b=(int)Math.ceil(a/30);
        try {
            for (int i = 1; i <= b; i++) {
                String jsonStr = sendGet("https://api.github.com/users/" + username + "/repos?page=" + i, headers);
                repoList = JSON.parseArray(jsonStr, GitHubUserRepo.class);
                for (GitHubUserRepo repo :  repoList) {
                    repoLists.add(repo);
                }
                /*repoList.forEach(v->{
                    repoLists.add(v);
                });*/
            }
        } catch (Exception e) {
            log.error("用户名不存在或者请求被限制");
            e.printStackTrace();
        }

        return repoLists;
    }
    public static String sendGet(String url,Map<String, String> headers) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            headers.forEach((key, value) -> {
                connection.setRequestProperty(key, value);
                System.out.println(key + ":" + value);
            });
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            connection.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //从某个用户开始，假设从52Lau开始
        String username="Germey";
        //获取用户主页
        GitHubUserInfo gitHubUserInfo = gen_user_page_url(username);

        //1、gen_user_follwer_url 获取用户粉丝列表
        gen_user_follwer_url(username,gitHubUserInfo.getFollowers());
        //2、gen_user_following_url 获取用户关注用户列表
        gen_user_following_url(username,gitHubUserInfo.getFollowing());
        //3、gen_user_repo_url 获取用户项目列表
        gen_user_repo_url(username,gitHubUserInfo.getPublic_repos());

    }

}
