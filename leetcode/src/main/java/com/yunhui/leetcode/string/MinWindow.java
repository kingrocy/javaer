package com.yunhui.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2020/9/17 5:42 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/minimum-window-substring/
 * @desc 给你一个字符串 S、一个字符串 T 。
 * 请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 */
public class MinWindow {


    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.compute(c, (k, oldValue) -> oldValue == null ? 1 : oldValue + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            //右移窗口 直到窗口中的字符 包含T中的所有字符
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.compute(c, (k, oldValue) -> oldValue == null ? 1 : oldValue + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            //判断左侧窗口是否要收缩
            while (valid == need.size()) {
                //更新最小覆盖子串
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
