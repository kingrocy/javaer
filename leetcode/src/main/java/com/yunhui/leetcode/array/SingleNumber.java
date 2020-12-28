package com.yunhui.leetcode.array;

/**
 * @Date : 2020/12/28 4:50 下午
 * @Author : dushaoyun
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
