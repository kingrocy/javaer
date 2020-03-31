package com.yunhui.leetcode;

/**
 * @Date : 2019-10-15 14:45
 * @Author :
 * @CopyRight :
 * @Desc : https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1042/
 */
public class TestSolution1 {

    public int maxProfit(int[] prices) {
        int max=0;
        int i=0;
        while(i<prices.length-1){
            int j=i+1;
            while(j<=prices.length-1){
                if(prices[j]>prices[i]){
                    max=(prices[j]-prices[i])>max?(prices[j]-prices[i]):max;
                }
                j++;
            }
            i++;
        }
        return max;
    }
}
