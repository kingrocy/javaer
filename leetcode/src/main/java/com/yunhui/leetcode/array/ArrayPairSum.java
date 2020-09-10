package com.yunhui.leetcode.array;

import java.util.Arrays;

/**
 * @Date : 2020/8/10 5:35 下午
 * @Author : dushaoyun
 */
public class ArrayPairSum {

    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //排序
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }
}
