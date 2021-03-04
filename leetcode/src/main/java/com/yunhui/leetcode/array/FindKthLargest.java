package com.yunhui.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Date : 2021/2/9 8:39 下午
 * @Author : dushaoyun
 * @desc https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class FindKthLargest {

    /**
     * 在未排序的数组中找到第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    /**
     * 使用优先级队列来做  队列里面 元素从小到大排列 只存储k个元素 队列的头部元素 就是第K个最大元素
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x));
        for (int num : nums) {
            queue.add(num);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.poll();
    }


}
