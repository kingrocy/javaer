package com.yunhui.leetcode.array;

/**
 * @Date : 2020/7/20 3:30 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/explore/featured/card/array-and-string/198/introduction-to-array/1412/
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length + 1;
    }
}
