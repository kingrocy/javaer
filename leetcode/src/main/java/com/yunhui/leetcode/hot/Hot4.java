package com.yunhui.leetcode.hot;

/**
 * @Date : 2020/6/19 10:56 上午
 * @Author : dushaoyun
 */
public class Hot4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] num = new int[(m + n) / 2 + 1 + 1];
        int j = 0, k = 0, l = 0;
        int target = (m + n) / 2;
        int p, q;
        while (l <= target) {
            if (j < m) {
                p = nums1[j];
            } else {
                p = Integer.MAX_VALUE;
            }
            if (k < n) {
                q = nums2[k];
            } else {
                q = Integer.MAX_VALUE;
            }
            if (p <= q) {
                num[l++] = p;
                j++;
            } else {
                num[l++] = q;
                k++;
            }
        }
        if ((m + n) % 2 == 0) {
            return (num[target - 1] + num[target]) / 2.0;
        }
        return num[target];
    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
    }
}
