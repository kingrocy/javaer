package com.yunhui.leetcode.string;

/**
 * @Date : 2020/8/3 10:13 上午
 * @Author : dushaoyun
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //遍历一次 先找出最短的那个字符
        int minLength = strs[0].length();
        int minIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
                minIndex = i;
            }
        }
        String tmp = strs[minIndex];
        while (tmp.length() > 0) {
            boolean flag = true;
            L1:
            for (String str : strs) {
                if (!str.startsWith(tmp)) {
                    flag = false;
                    break L1;
                }
            }
            if (flag) {
                return tmp;
            }
            tmp = tmp.substring(0, tmp.length() - 1);
        }
        return "";
    }
}
