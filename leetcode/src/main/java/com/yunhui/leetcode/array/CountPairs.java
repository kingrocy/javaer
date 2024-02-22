package com.yunhui.leetcode.array;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Created on 2024-02-22
 * https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/
 *
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 target ，请你返回满足 0 <= i < j < n 且 nums[i] + nums[j] < target 的下标对 (i, j) 的数目。
 */
public class CountPairs {

    public static int countPairs(List<Integer> nums, int target) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        Collections.sort(nums);
        int ans = 0;
        for (int j = nums.size() - 1; j >= 1; j--) {
            //固定j，在[i,j-1]中找 满足条件的 最大的i
            int i = j - 1;  //从后往前遍历，因为是有序的
            while (i >= 0) {
                if (nums.get(i) + nums.get(j) < target) {  //可以拿二分查找优化
                    ans += i + 1;
                    break;
                } else {
                    i--;
                }
            }
        }
        return ans;
    }

    /**
     * 二分查找优化
     * @param nums
     * @param target
     * @return
     */
    public static int countPairs2(List<Integer> nums, int target) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        Collections.sort(nums);
        int ans = 0;
        for (int j = nums.size() - 1; j >= 1; j--) {
            //固定j，在[i,j-1]中找 满足条件的 最大的i  使得nums.get(i) + nums.get(j) < target
            int left = 0, right = j - 1;  //从后往前遍历，因为是有序的
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums.get(mid) + nums.get(j) < target) {
                    //往右收缩  [mid+1,right]
                    left = mid + 1;
                } else {
                    //往左收缩  [left,mid-1]
                    right = mid - 1;
                }
            }
            if (right < 0 || right >= nums.size()) {
                continue;
            }
            if (nums.get(right) + nums.get(j) < target) {
                ans += right + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        List<Integer> nums = Lists.newArrayList(-1, -5, 4, 4, -10);

        // -10 -5 -1 4 4
        System.out.println(countPairs2(nums, -6));
    }
}
