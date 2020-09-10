package com.yunhui.leetcode.string;

/**
 * @Date : 2020/8/10 5:29 下午
 * @Author : dushaoyun
 */
public class ReverseString {

    public void reverseString(char[] s) {
        if (s == null || s.length <= 0) {
            return;
        }
        char tmp;
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
