package com.yunhui.design.pattern.factory;

/**
 * @Date : 2020/12/21 4:22 下午
 * @Author : dushaoyun
 */
public interface ApplicationContext {

    Object getBean(String beanId);
}
