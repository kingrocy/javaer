package com.yunhui.leetcode.hot_100;


import java.util.HashSet;
import java.util.Set;

/**
 * Created on 2024-01-09
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abccba"));
        System.out.println(lengthOfLongestSubstring2("bbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return s.length();
        }
        int left = 0;
        int right = 0;
        int max = 0;
        while (left < s.length() && right < s.length()) {
            //性能非最优 可以使用hashset来优化
            boolean containsed = s.substring(left, right).contains(String.valueOf(s.charAt(right)));
            if (!containsed) {
                right++;
                max = Math.max(max, right - left);
            } else {
                left++;
            }
        }
        return max;
    }

    /**
     * 使用优化后的hashset实现
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return s.length();
        }
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (left < s.length() && right < s.length()) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                right++;
                max = Math.max(max, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}
