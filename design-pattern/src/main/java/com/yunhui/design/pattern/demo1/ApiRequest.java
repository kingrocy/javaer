package com.yunhui.design.pattern.demo1;

import lombok.Getter;

/**
 * @Date : 2020/12/18 4:06 下午
 * @Author : dushaoyun
 */
@Getter
public class ApiRequest {

    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public static ApiRequest buildFromUrl(String url) {

        return null;
    }


}
