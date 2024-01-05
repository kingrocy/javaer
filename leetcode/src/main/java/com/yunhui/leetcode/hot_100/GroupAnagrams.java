package com.yunhui.leetcode.hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2024-01-05
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        Map<String, List<String>> dict = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if (dict.containsKey(key)) {
                dict.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                dict.put(key, list);
            }
        }
        if (dict.size() > 0) {
            return new ArrayList<>(dict.values());
        }
        return null;
    }
}
