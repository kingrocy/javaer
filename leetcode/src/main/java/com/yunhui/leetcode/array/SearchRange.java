package com.yunhui.leetcode.array;

/**
 * @Date : 2020/7/6 2:47 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class SearchRange {

    public static void main(String[] args) {
        int [] arr=new int[]{1,2,3,4,4,4,4,4,5,6,7};
        int[] ints = searchRange(arr, 4);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[]{-1, -1};
        if (n == 0) {
            return res;
        }
        if (n == 1) {
            return nums[0] == target ? new int[]{0, 0} : res;
        }
        int left = 0;
        int right = n - 1;
        //先搜索左 再搜索右
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //找到了 往左往右 搜索
                int p = mid;
                int q = mid;
                while (p >= left) {
                    if (nums[p] == target) {
                        res[0] = p;
                    } else {
                        break;
                    }
                    p--;
                }
                while (q <= right) {
                    if (nums[q] == target) {
                        res[1] = q;
                    } else {
                        break;
                    }
                    q++;
                }
                return res;
            }
        }
        return res;
    }
}
