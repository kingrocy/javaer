package com.yunhui.leetcode.array;

/**
 * Created on 2024-02-22
 */
public class SearchRange2 {


    public static void main(String[] args) {
        int[] nums = new int[] {1};
        SearchRange2 searchRange2 = new SearchRange2();
        int[] ints = searchRange2.searchRange(nums, 0);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[] {searchRangeLeft(nums, target), searchRangeRight(nums, target)};
    }


    public int searchRangeLeft(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                //搜索区间变成 [left,mid-1]
                right = mid - 1;
            } else if (nums[mid] < target) {
                //搜索区间变成 [mid+1,right]
                left = mid + 1;
            } else {
                //收缩右侧区间 [left,mid-1]
                right = mid - 1;
            }
        }
        //循环结束后 区间变成 [right+1,right] left=right
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }


    public int searchRangeRight(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                //搜索区间变成 [left,mid-1]
                right = mid - 1;
            } else if (nums[mid] < target) {
                //搜索区间变成 [mid+1,right]
                left = mid + 1;
            } else {
                //收缩左侧区间 [left,mid-1]
                left = mid + 1;
            }
        }
        //循环结束后 区间变成 [mid+1,right]  mid=left-1
        if (right < 0 || right >= nums.length) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    }

}
