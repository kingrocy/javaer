package com.yunhui.leetcode.medium;

/**
 * @Date : 2020/6/18 11:06 上午
 * @Author : dushaoyun
 */
public class TaskmaxScoreSightseeingPair {

    public int maxScoreSightseeingPair(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < ((A.length >= 2000 + i) ? 2000 + i : A.length); j++) {
                max = Math.max(max, A[i] + A[j] + i - j);
            }
        }
        return max;
    }
}
