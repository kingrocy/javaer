package com.yunhui.leetcode.every_day_exer;

/**
 * @Date : 2020/7/16 5:33 下午
 * @Author : dushaoyun
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i];
            }else{
                dp[i]=nums[i];
            }
            max=Math.max(max, dp[i]);
        }
        return max;
    }

}
