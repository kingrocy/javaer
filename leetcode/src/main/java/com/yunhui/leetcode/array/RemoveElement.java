package com.yunhui.leetcode.array;

/**
 * @Date : 2021/1/19 10:56 上午
 * @Author : dushaoyun
 */
public class RemoveElement {

    //双指针
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
