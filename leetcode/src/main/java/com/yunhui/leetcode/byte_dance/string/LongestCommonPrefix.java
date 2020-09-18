package com.yunhui.leetcode.byte_dance.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Date : 2020/9/10 4:01 下午
 * @Author : dushaoyun
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, Comparator.comparingInt(String::length));

        StringBuilder sb = new StringBuilder(strs[0]);

        while (sb.length() > 0) {
            boolean approve = true;
            for (String str : strs) {
                if (!str.startsWith(sb.toString())) {
                    sb.deleteCharAt(sb.length() - 1);
                    approve = false;
                    break;
                }
            }
            if(approve){
                return sb.toString();
            }
        }

        return "";
    }
}
