package com.yunhui.leetcode.easy;

/**
 * @Date : 2020/5/29 3:29 下午
 * @Author : dushaoyun
 * @Link : https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/comments/
 */
public class TaskMaxProfit2 {


    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }
}
