package com.yunhui.leetcode.hot_100;

/**
 * Created on 2024-01-09
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
