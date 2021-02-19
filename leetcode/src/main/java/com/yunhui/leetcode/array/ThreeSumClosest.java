package com.yunhui.leetcode.array;

import java.util.Arrays;

/**
 * @Date : 2021/2/17 4:38 下午
 * @Author : dushaoyun
 * @desc 最接近的三数之和
 * @link https://leetcode-cn.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = i + 1;
            int c = nums.length - 1;
            while (b < c) {
                int sum = a + nums[b] + nums[c];
                if (sum > target) {
                    c--;
                } else if (sum < target) {
                    b++;
                } else {
                    return sum;
                }
                res = Math.abs(sum - target) > Math.abs(res - target) ? res : sum;
            }
        }
        return res;
    }
}
