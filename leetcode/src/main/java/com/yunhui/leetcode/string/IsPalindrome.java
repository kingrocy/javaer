package com.yunhui.leetcode.string;

/**
 * @Date : 2020/12/28 4:44 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/valid-palindrome/
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
