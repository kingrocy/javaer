package com.yunhui.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Date : 2021/2/17 2:12 下午
 * @Author : dushaoyun
 */
public class SingleNumber_II {


    public int singleNumber(int[] nums) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int num : nums) {
            if (dict.containsKey(num)) {
                dict.put(num, dict.get(num) + 1);
            } else {
                dict.put(num, 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = dict.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
