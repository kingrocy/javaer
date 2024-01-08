package com.yunhui.leetcode.hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * Created on 2024-01-08
 */
public class ThreeSum {


    public static void main(String[] args) {
        int[] nums = new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}; //  -4 -1 -1 0 1 2
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(JSON.toJSONString(lists));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //当前数字大于0，直接返回
            if (nums[i] > 0) {
                break;
            }
            //跳过重复数字
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //缩减区间 需要去重
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
