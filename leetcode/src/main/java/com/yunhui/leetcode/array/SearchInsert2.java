package com.yunhui.leetcode.array;

/**
 * Created on 2024-02-22
 * https://leetcode.cn/problems/search-insert-position/?show=1
 */
public class SearchInsert2 {

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1, 3, 4, 5}, 2));
    }
}
