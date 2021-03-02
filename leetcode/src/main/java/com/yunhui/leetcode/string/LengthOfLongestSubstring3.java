package com.yunhui.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2021/3/2 9:56 上午
 * @Author : dushaoyun
 */
public class LengthOfLongestSubstring3 {


    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s == null || s.length() == 0) {
            return max;
        }
        int left = 0;
        int right = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            //需要添加到窗口的数据
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            //判断窗口内是否包含重复字符
            while (window.get(c) > 1) {
                //需要移除窗口的数据
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            //重复的字符被移除掉 此时的窗口内的数据就没有重复的字符
            max=Math.max(max,right-left);
        }
        return max;
    }
}
