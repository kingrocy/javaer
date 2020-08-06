package com.yunhui.leetcode.string;

/**
 * @Date : 2020/8/6 5:56 下午
 * @Author : dushaoyun
 */
public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("hello","ll"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        int i = haystack.length();
        int j = needle.length();
        for (int k = 0; k < i - j + 1; k++) {
            if (haystack.substring(k, j + k).equals(needle)) {
                return k;
            }
        }
        return -1;
    }
}
