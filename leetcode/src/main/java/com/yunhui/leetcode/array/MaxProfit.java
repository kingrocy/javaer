package com.yunhui.leetcode.array;

/**
 * @Date : 2021/1/6 10:24 上午
 * @Author : dushaoyun
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int max=0;
        for (int price : prices) {
            if(price<minPrice){
                minPrice=price;
            }
            int diff=price-minPrice;
            if(diff>max){
                max=diff;
            }
        }
        return max;
    }
}
