package com.yunhui.leetcode.hot;

import java.util.HashSet;
import java.util.Set;

/**
 * @Date : 2020/6/18 2:17 下午
 * @Author : dushaoyun
 */
public class Hot3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> sets = new HashSet<>();
        int max = 0;
        char[] chars = s.toCharArray();
        L1:
        for (int i = 0; i < chars.length; i++) {
            L2:
            for (int j = i; j < chars.length; j++) {
                Character character = Character.valueOf(chars[j]);
                if (sets.contains(character)) {
                    max = Math.max(max, sets.size());
                    sets.clear();
                    break L2;
                } else {
                    sets.add(character);
                }
            }
        }
        return Math.max(max, sets.size());
    }
}
