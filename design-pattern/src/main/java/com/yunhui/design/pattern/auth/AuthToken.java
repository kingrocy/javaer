package com.yunhui.design.pattern.auth;

/**
 * @Date : 2020/12/18 3:59 下午
 * @Author : dushaoyun
 */
public class AuthToken {


    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;


    private String token;

    private long createdTime;

    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createdTime) {
        this.token = token;
        this.createdTime = createdTime;
    }

    public AuthToken(String token, long createdTime, long expiredTimeInterval) {
        this.token = token;
        this.createdTime = createdTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public String getToken() {
        return token;
    }

    public static AuthToken create(String baseUrl, String token, String appId, long timestamp) {
        return null;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - createdTime < expiredTimeInterval;
    }


    public boolean match(AuthToken authToken) {
        return false;
    }
}
