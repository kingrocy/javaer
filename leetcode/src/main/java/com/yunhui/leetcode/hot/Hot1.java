package com.yunhui.leetcode.hot;

/**
 * @Date : 2020/6/18 10:44 上午
 * @Author : dushaoyun
 */
public class Hot1 {

    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }
}