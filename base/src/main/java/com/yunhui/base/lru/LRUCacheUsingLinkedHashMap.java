package com.yunhui.base.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Date : 2020/6/2 2:43 下午
 * @Author : dushaoyun
 */
public class LRUCacheUsingLinkedHashMap {

    private LinkedHashMap<String, Integer> data;

    public LRUCacheUsingLinkedHashMap(int capacity) {
        data = new LinkedHashMap<String, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(String key) {
        return data.containsKey(key) ? data.get(key) : -1;
    }

    public void put(String key, int value) {
        data.put(key, value);
    }

}
