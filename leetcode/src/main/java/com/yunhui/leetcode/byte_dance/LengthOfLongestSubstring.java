package com.yunhui.leetcode.byte_dance;

import java.util.HashSet;
import java.util.Set;

/**
 * @Date : 2020/9/9 5:12 下午
 * @Author : dushaoyun
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 1;
        L1:
        for (int i = 0; i < s.length() - 1; i++) {
            String str = s.substring(i, i + 1);
            L2:
            for (int j = i + 1; j < s.length(); j++) {
                if (!str.contains(String.valueOf(s.charAt(j)))) {
                    str = s.substring(i, j + 1);
                    max = Math.max(max, str.length());
                } else {
                    continue L1;
                }
            }
        }
        return max;
    }


    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int max = 1;
        int j = 0;
        L1:
        for (int i = 0; i < chars.length; i++) {
            if(i!=0){
                set.remove(chars[i-1]);
            }
            L2:
            for (int k = j; k < chars.length; k++) {
                if (!set.contains(chars[k])) {
                    set.add(chars[k]);
                    max = Math.max(max, k - i + 1);
                } else {
                    j = k;
                    continue L1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("\"abcabcbb"));
    }
}
