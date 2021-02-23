package com.yunhui.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2021/2/23 4:03 下午
 * @Author : dushaoyun
 * @link:https://leetcode-cn.com/problems/permutation-in-string/
 * @desc 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 */
public class CheckInclusion {


    /**
     * 判断s2是否包含s1的排列
     * <p>
     * 使用labuladong的滑动窗口思想实现
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return false;
        }
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            //需要加入到窗口的字符
            char c = s2.charAt(right);
            right++;
            //窗口内数据更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            //判断是否要收缩窗口 注意 此处的条件是 看窗口的大小是否大于等于s1的长度 如果是 那么就需要检查
            while (right - left >= s1.length()) {
                //如果valid的长度=need窗口的大小 那么就是找到了
                if (valid == need.size()) {
                    return true;
                }
                //没有找到说明当前窗口不满足题意 需要缩减
                //需要移出窗口的元素
                char d = s2.charAt(left);
                left++;
                //进行窗口内的元素更新操作
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
