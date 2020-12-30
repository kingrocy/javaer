package com.yunhui.leetcode.array;

/**
 * @Date : 2020/12/30 10:05 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/maximum-subarray/submissions/
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


    public int maxSubArray2(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

