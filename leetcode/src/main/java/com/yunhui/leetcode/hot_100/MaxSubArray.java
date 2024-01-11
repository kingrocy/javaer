package com.yunhui.leetcode.hot_100;

/**
 * Created on 2024-01-10
 */
public class MaxSubArray {


    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-1}));
    }

    /**
     * f(i)的意思是 以i结尾的最大子数组和
     * 当i=0, f(0)=nums[0]
     * 当i>=1，f(i)=max(f(i-1)+nums[i],nums[i]),
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
