package com.yunhui.design.pattern.auth;

/**
 * @Date : 2020/12/18 4:10 下午
 * @Author : dushaoyun
 */
public interface CredentialStorage {

    String getPasswordByAppId(String appId);

}
