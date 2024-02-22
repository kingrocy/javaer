package com.yunhui.leetcode.hot_100;

import java.util.Arrays;
import java.util.Comparator;

import com.alibaba.fastjson.JSON;

/**
 * Created on 2024-01-10
 */
public class Merge {

    /**
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        //先对intervals进行排序，根据区间的起点进行升序 因为存在/[[2,3],[4,5],[6,7],[8,9],[1,10]]   -> [1,10]这种情况
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int[][] result = new int[intervals.length][2];
        int k = 0;
        result[k] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] right = intervals[i];
            int[] left = result[k];
            //没有重叠
            if (right[0] > left[1] || right[1] < left[0]) {
                result[++k] = right;
            } else {
                //存在{{1, 4}, {0, 4}};这种情况
                result[k] = new int[] {left[0], Math.max(left[1], right[1])};
            }
        }
        return Arrays.copyOf(result, k + 1);
    }

    public static void main(String[] args) {
        int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        //[[2,3],[4,5],[6,7],[8,9],[1,10]]   -> [1,10]
        int[][] merge = merge(intervals);
        System.out.println(JSON.toJSONString(merge));
    }
}
