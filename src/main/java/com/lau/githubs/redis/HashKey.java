package com.lau.githubs.redis;

public class HashKey extends BasePrefix {

    private HashKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static HashKey getHashKey= new HashKey(60,"hash");
}
