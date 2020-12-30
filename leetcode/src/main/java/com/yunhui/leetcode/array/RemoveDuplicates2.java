package com.yunhui.leetcode.array;

/**
 * @Date : 2020/12/30 9:40 上午
 * @Author : dushaoyun
 * @link : https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates2 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0, q = 1;
        while (q < nums.length) {
            if (nums[q] != nums[p]) {
                nums[++p] = nums[q];
            }
            q++;
        }
        return p + 1;
    }
}
