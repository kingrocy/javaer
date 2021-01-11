package com.yunhui.leetcode.array;

import java.util.Arrays;

/**
 * @Date : 2021/1/11 5:16 下午
 * @Author : dushaoyun
 */
public class MajorityElement2 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
