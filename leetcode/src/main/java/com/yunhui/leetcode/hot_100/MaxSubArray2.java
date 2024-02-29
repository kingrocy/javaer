package com.yunhui.leetcode.hot_100;

/**
 * Created on 2024-02-29
 */
public class MaxSubArray2 {


    //dp[i]=Math.max(dp[i-1]+nums[i],nums[i])
    //dp[0]=nums[0]
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
