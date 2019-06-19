package com.lau.githubs.redis;

public class GitHubKey extends BasePrefix {

    private GitHubKey(String prefix) {
        super(prefix);
    }

    public static GitHubKey getBaiduKey= new GitHubKey("github");
}
