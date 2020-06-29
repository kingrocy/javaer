package com.yunhui.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Date : 2020/6/29 6:03 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {

    public static void main(String[] args) {
        threeSum(new int[]{-2, 0, 0, 2, 2});
    }

    /**
     * 先排序 再双指针
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else {
                    if (sum < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
