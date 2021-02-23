package com.yunhui.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2021/2/23 3:50 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @desc :给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring2 {


    /**
     * 使用滑动窗口思想
     *
     * @param s
     * @return ref：https://labuladong.gitbook.io/algo/bi-du-wen-zhang/hua-dong-chuang-kou-ji-qiao-jin-jie#si-zui-chang-wu-zhong-fu-zi-chuan
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            //更新窗口内数据
            window.put(c, window.getOrDefault(c, 0) + 1);
            //判断是否需要收缩左侧窗口
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            //窗口收缩完之后 窗户内的数据一定是不含重复字符的子串

            //注意：窗口是左闭右开的  [left,right)  所以窗口长度=right-left
            max = Math.max(max, right - left);
        }
        return max;
    }
}
