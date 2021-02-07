package com.yunhui.leetcode.array;

/**
 * @Date : 2021/2/7 4:30 下午
 * @Author : dushaoyun
 * @desc https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = (m + n) / 2;
        //两个数组的指针
        int p = 0;
        int q = 0;
        int left = -1, right = -1;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (p < m && (q >= n || (nums1[p] <= nums2[q]))) {
                right = nums1[p++];
            } else {
                right = nums2[q++];
            }
        }
        if (len % 2 == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }
}
