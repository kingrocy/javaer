package com.yunhui.leetcode.hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2024-01-09
 */
public class FindAnagrams {

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("cbaebabacd", "abc");
        for (Integer anagram : anagrams) {
            System.out.println(anagram);
        }
    }

    /**
     * 判断两个字符串是否是 异位词 有没有更好的办法
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null) {
            return res;
        }
        if (s.length() < p.length()) {
            return res;
        }
        char[] pCharArray = p.toCharArray();
        Arrays.sort(pCharArray);
        String targetKey = new String(pCharArray);
        int left = 0;
        int right = 0;
        while (left < s.length() && right < s.length()) {
            while (right < s.length() && right - left < p.length()) {
                right++;
            }
            String substring = s.substring(left, right);
            char[] substringCharArray = substring.toCharArray();
            Arrays.sort(substringCharArray);
            String key = new String(substringCharArray);
            if (key.equals(targetKey)) {
                res.add(left);
            }
            left++;
        }
        return res;
    }
}
