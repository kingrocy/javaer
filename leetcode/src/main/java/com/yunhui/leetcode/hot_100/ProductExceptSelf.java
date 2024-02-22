package com.yunhui.leetcode.hot_100;

/**
 * Created on 2024-01-15
 */
public class ProductExceptSelf {

    /**
     *
     * 1 2 3 4
     *
     * x 2 3 4
     * 1 x 3 4
     * 1 2 x 4
     * 1 2 3 x
     *
     * x=1
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
