package com.yunhui.leetcode.easy;

/**
 * @Date : 2019-09-11 17:12
 * @Desc : 判断是否是一个回文数
 * @link : https://leetcode-cn.com/problems/palindrome-number/
 */
public class TaskIsPalindrome {

    /**
     * 使用将数字转换为字符串的形式 反转字符串来判断是否是回文
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        String str = String.valueOf(x);
        char[] reverse = new char[str.length()];
        int j = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse[j++] = str.charAt(i);
        }
        return str.equals(String.valueOf(reverse));
    }

    /**
     * 计算每位的
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        boolean flag=x>0?true:false;
        int y=x;
        int result = 0;
        while (x != 0) {
            int n = x % 10;
            x /= 10;
            result = result * 10 + n;
        }
        System.out.println(result);
        return result == (flag==true?y:-y);
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome1(-121));
        System.out.println(isPalindrome2(-121));
    }
}
