package com.yunhui.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Date : 2021/2/9 9:33 下午
 * @Author : dushaoyun
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cnt = 1;
                while (set.contains(++num)) {
                    cnt++;
                    max = Math.max(max, cnt);
                }
            }
        }
        return max;
    }
}
