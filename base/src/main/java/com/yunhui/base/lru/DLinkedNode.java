package com.yunhui.base.lru;

import lombok.Data;

/**
 * @Date : 2020/6/11 2:11 下午
 * @Author : dushaoyun
 */
@Data
public class DLinkedNode {
    String key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;
}
