package com.lau.githubs.redis;

public class BaiduKey extends BasePrefix {

    private BaiduKey(String prefix) {
        super(prefix);
    }

    public static BaiduKey getBaiduKey= new BaiduKey("baidu");
}
