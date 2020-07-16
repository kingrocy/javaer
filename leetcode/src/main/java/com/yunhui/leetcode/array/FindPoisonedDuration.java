package com.yunhui.leetcode.array;

/**
 * @Date : 2020/7/6 2:33 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/teemo-attacking/
 */
public class FindPoisonedDuration {


    /**
     * 提莫攻击
     *
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total_duration = 0;
        if (timeSeries.length > 0) {
            total_duration = duration;
        }
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int diff = timeSeries[i + 1] - timeSeries[i];
            if (diff > duration) {
                total_duration += duration;
            } else {
                total_duration += diff;
            }
        }
        return total_duration;
    }

}
