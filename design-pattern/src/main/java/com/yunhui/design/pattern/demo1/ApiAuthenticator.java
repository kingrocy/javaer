package com.yunhui.design.pattern.demo1;

/**
 * @Date : 2020/12/18 4:11 下午
 * @Author : dushaoyun
 */
public interface ApiAuthenticator {

    void auth(String url);

    void auth(ApiRequest apiRequest);
}
