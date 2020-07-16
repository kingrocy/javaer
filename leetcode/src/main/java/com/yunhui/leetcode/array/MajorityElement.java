package com.yunhui.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2020/7/7 9:24 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/majority-element/submissions/
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> dict = new HashMap<>();
        int maj = nums[0];
        int max = 0;
        for (int num : nums) {
            if (dict.containsKey(num)) {
                int cur = dict.get(num) + 1;
                if (cur > max) {
                    max = cur;
                    maj = num;
                }
                dict.put(num, cur);
            } else {
                dict.put(num, 1);
            }
        }
        return maj;
    }

    public int majorityElement1(int[] nums) {
        int maj = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                maj = num;
            }
            if (num == maj) {
                count++;
            } else {
                count--;
            }

        }
        return maj;
    }


    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
