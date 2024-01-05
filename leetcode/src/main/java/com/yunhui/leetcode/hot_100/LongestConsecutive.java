package com.yunhui.leetcode.hot_100;

import java.util.Arrays;

/**
 * Created on 2024-01-05
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {0, 1, 1, 2}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = left + 1;
        int count = 1;
        int max = 1;
        while (right < nums.length) {
            if (nums[right] == nums[right - 1]) {
                //如果两个数字相等，需要跳过
                right++;
            } else if (nums[right] == nums[right - 1] + 1) {
                right++;
                count++;
                max = Math.max(count, max);
            } else {
                left = right;
                right = left + 1;
                count = 1;
            }
        }
        return max;
    }
}
