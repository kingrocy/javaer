package com.yunhui.leetcode.hot_100;

/**
 * Created on 2024-01-08
 */
public class MoveZeroes {

    //更容易理解的双指针
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0;
        while (left < nums.length) {
            //先找=0的元素
            while (left < nums.length && nums[left] != 0) {
                left++;
            }
            if (left >= nums.length) {
                return;
            }
            //找不等于0的元素
            int right = left + 1;
            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            if (right >= nums.length) {
                return;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
        }
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
