package com.yunhui.leetcode.array;

/**
 * @Date : 2021/2/7 9:35 上午
 * @Author : dushaoyun
 * @Desc 搜索旋转排序数组
 * @link https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class Search {

    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 4, 1, 2, 3}, 2));
    }

    public static int search(int[] nums, int target) {
        //做题第一步 边际判断
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        //
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //因为mid 节点 要么左边是有序的 要么右边是有序的
            if (nums[0] <= nums[mid]) {
                //左边的数组是有序的
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //右边的数组是有序的
                if (target > nums[mid] && target <= nums[right]) {
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}
