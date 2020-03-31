package com.yunhui.leetcode.easy;

/**
 * @Date : 2020/3/31 3:59 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/search-insert-position/
 * @desc 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class TaskSearchInsert {

    /**
     * 需要考虑头尾的极端值   假如target 应该在头部和尾部时 需要怎么样处理？
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] >= target) {
                if (index == 0) {
                    index = i - 1;
                }
            } else {
                index = i + 1;
            }
        }
        return index<0?0:index;
    }
}
