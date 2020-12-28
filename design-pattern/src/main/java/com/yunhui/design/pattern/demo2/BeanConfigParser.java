package com.yunhui.design.pattern.demo2;

import java.io.InputStream;
import java.util.List;

/**
 * @Date : 2020/12/21 4:40 下午
 * @Author : dushaoyun
 */
public interface BeanConfigParser {

    List<BeanDefinition> parse(InputStream inputStream);

    List<BeanDefinition> parse(String configContent);
}