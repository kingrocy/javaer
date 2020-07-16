package com.yunhui.leetcode.every_day_exer;

/**
 * @Date : 2020/7/8 5:23 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/diving-board-lcci/
 */
public class DivingBoard {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k <= 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter*k};
        }
        int[] arr = new int[k + 1];
        int i = 0;
        int left = k;
        while (left >= 0) {
            arr[i++] = shorter * left + longer * (k - left);
            left--;
        }
        return arr;
    }
}
