package com.yunhui.leetcode.string;

/**
 * @Date : 2020/8/3 10:27 上午
 * @Author : dushaoyun
 */
public class LongestPalindrome {


    public String longestPalindrome(String s) {
        if (s == null) {
            return s;
        }
        if (s != null && s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (isPalindrome(chars, i, j) && (j - i + 1) > max) {
                    start = i;
                    end = j;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(start, end + 1);
    }


    public boolean isPalindrome(char[] chars, int start, int end) {
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
