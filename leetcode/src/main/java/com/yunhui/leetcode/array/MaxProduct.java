package com.yunhui.leetcode.array;

/**
 * @Date : 2021/2/17 2:42 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/
 * @desc 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 */
public class MaxProduct {

    /**
     * 根据题意 只需要找到数组里面 最大的两个数即可
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        /**
         * 最大值
         */
        int max1 = 0;
        /**
         * 第二大值
         */
        int max2 = 0;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2=num;
            }
        }
        return (max1-1)*(max2-1);
    }
}
