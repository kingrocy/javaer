package com.yunhui.leetcode.string;

/**
 * @Date : 2021/1/6 10:43 上午
 * @Author : dushaoyun
 */
public class ValidPalindrome {


    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isValid(s, left, right - 1) || isValid(s, left + 1, right);
            }
            left++;
            right--;
        }
        return true;
    }


    private boolean isValid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
