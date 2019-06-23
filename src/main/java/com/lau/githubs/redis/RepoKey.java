package com.lau.githubs.redis;

/**
 * @author bka
 * @date 2019-06-23 22:09
 */
public class RepoKey extends BasePrefix {
    public RepoKey(String prefix) {
        super(prefix);
    }

    public static RepoKey getRepoKey= new RepoKey("repo");
}
