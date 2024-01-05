package com.yunhui.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2020/8/10 5:40 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum2 {


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
