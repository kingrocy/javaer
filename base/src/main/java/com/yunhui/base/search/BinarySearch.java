package com.yunhui.base.search;

/**
 * @Date : 2020/7/6 3:06 下午
 * @Author : dushaoyun
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10}, 2));
    }

    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = left + (right - left) / 2;
            if (nums[index] > target) {
                right = index - 1;
            } else if (nums[index] < target) {
                left = index + 1;
            } else {
                return index;
            }
        }
        return -1;
    }

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // if (left - 1 < 0 || left - 1 >= nums.length) {
        //     return -1;
        // }

        // 由于 while 的结束条件是 right == left - 1，且现在在求右边界
        // 所以用 right 替代 left - 1 更好记
        if (right < 0 || right >= nums.length) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    }

}
