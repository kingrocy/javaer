package com.yunhui.leetcode.hot_100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2024-01-05
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            if (dict.containsKey(target - left)) {
                return new int[] {i, dict.get(target - left)};
            }else{
                dict.put(left, i);
            }
        }
        return res;
    }

}
