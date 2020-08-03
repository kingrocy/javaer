package com.yunhui.leetcode.array;

import java.util.Arrays;

/**
 * @Date : 2020/7/20 3:36 下午
 * @Author : dushaoyun
 */
public class Merge {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] arrs = new int[intervals.length][2];
        arrs[0] = intervals[0];
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] arr = arrs[index];
            int[] ints = intervals[i];
            if (ints[0] > arr[1]) {
                arrs[++index] = ints;
            } else {
                arrs[index] = new int[]{Math.min(arr[0], ints[0]), Math.max(arr[1], ints[1])};
            }
        }
        return Arrays.copyOfRange(arrs, 0, index + 1);
    }
}
