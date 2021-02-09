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
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return arr;
        }
        //排序
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return arr;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int target = 0 - nums[i];
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    //存入符合要求的值
                    arr.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    //这里需要注意顺序
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return arr;
    }
}