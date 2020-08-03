package com.yunhui.leetcode.array;

/**
 * @Date : 2020/7/20 3:24 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/explore/featured/card/array-and-string/198/introduction-to-array/770/
 */
public class PivotIndex {

    /**
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        //计算总大小
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == cur * 2) {
                return i;
            } else {
                cur += nums[i];
            }
        }
        return -1;
    }
}
