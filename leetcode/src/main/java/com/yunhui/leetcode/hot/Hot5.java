package com.yunhui.leetcode.hot;

/**
 * @Date : 2020/6/19 1:38 下午
 * @Author : dushaoyun
 */
public class Hot5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    /**
     * 无脑遍历
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if(chars.length<=1){
            return s;
        }
        int start = 0;
        int max = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (validatePalindrome(chars, i, j)) {
                    if (j - i + 1 > max) {
                        start = i;
                        max = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start, max + start);
    }

    private static boolean validatePalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
