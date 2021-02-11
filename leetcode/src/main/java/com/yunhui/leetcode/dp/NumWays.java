package com.yunhui.leetcode.dp;

/**
 * @Date : 2021/2/10 10:28 下午
 * @Author : dushaoyun
 */
public class NumWays {

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = b;
            b = (a + b) % 1000000007;
            a = temp;
        }
        return b;
    }
}
