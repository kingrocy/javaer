package com.yunhui.design.pattern.auth;

/**
 * @Date : 2020/12/18 4:11 下午
 * @Author : dushaoyun
 */
public interface ApiAuthenticator {

    void auth(String url);

    void auth(ApiRequest apiRequest);
}
