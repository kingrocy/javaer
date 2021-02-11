package com.yunhui.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2021/2/10 11:03 下午
 * @Author : dushaoyun
 * @link:https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/submissions/
 * @desc 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    /**
     * 解题思路

     滑动窗口法

     使用一个hashmap 记录窗口内的每个元素的index

     当end指针移动到新位置时，窗口内的元素重复

     我们需要将start的指针位置 移动到一个 使当前窗口内的元素不重复的位置

     怎么移动呢？ hashmap 找出冲突的那个元素的index。取index+1 和 start的最大值就好了。

     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> dict = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        for (; end < s.length(); end++) {
            char c = s.charAt(end);
            if (dict.containsKey(c)) {
                //这边为啥需要取 index+1 和 start的最大值呢？ 因为 dict 一直在put元素 而没有移除窗口外的元素
                //通过取index+1 和 start位置的最大值  能够避免start指针移动到了窗口外部。
                // 举例说明 比如 abba  当end指针来到最后一个字符a时，此时start=2 end=3 而dict.get(a)=0
                //如果不使用Math.max(start, dict.get(c) + 1)  那么start指针将会又跑到窗口的左侧外面。
                start = Math.max(start, dict.get(c) + 1);
            }
            dict.put(c, end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
