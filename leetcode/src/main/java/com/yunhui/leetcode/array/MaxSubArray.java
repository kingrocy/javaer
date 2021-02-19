package com.yunhui.leetcode.array;

/**
 * @Date : 2020/12/30 10:05 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/maximum-subarray/submissions/
 */
public class MaxSubArray {

    /**
     * 使用动态规划
     * 状态转移公式 f(i)=max((f(i-1)+nums[i]),nums[i])
     * f(0)=nums[0]
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int [] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }

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

