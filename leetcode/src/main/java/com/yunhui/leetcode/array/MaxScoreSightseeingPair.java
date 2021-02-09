package com.yunhui.leetcode.array;

/**
 * @Date : 2021/2/8 3:25 下午
 * @Author : dushaoyun
 */
public class MaxScoreSightseeingPair {

    public int maxScoreSightseeingPair(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                max = Math.max(max, A[j] + A[i] + (i - j));
            }
        }
        return max;
    }
}
