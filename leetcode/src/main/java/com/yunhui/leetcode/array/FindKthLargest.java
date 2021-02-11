package com.yunhui.leetcode.array;

import java.util.Arrays;

/**
 * @Date : 2021/2/9 8:39 下午
 * @Author : dushaoyun
 * @desc https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class FindKthLargest {

    /**
     * 在未排序的数组中找到第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
