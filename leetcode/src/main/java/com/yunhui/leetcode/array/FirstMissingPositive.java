package com.yunhui.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2020/6/29 4:02 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 1};
        FirstMissingPositive.firstMissingPositive2(arr);
    }

    /**
     * 遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，
     * [注意：碰到数组大于 0，小于等于 n 就直接 swap 到对应位置，然后指针留在原地继续判断是否要 swap。其他情况下指针向右移动一格。]
     * 然后再遍历一次数组查当前下标是否和值对应，
     * 如果不对应那这个下标就是答案，否则遍历完都没出现那么答案就是数组长度加1。
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive2(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; ) {
            //nums[i] != nums[nums[i] - 1]  防止两个相同的数交换导致死循环
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                //交换  nums[i]   nums[nums[i]-1]
                temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    /**
     * leetcode上的标记方法
     * 遍历两次
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }


    /**
     * 不满足题意 空间复杂度为o（n）
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                arr[nums[i] - 1] = nums[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }


    public int firstMissingPositive4(int[] nums) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int num : nums) {
            dict.put(num, num);
        }
        int i = 1;
        while (true) {
            if (!dict.containsKey(i)) {
                return i;
            } else {
                i++;
            }
        }
    }
}
