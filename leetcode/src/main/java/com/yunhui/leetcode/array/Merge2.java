package com.yunhui.leetcode.array;

/**
 * @Date : 2020/12/31 4:59 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/merge-sorted-array/submissions/
 */
public class Merge2 {

    public static void main(String[] args) {
        merge2(new int[]{2, 0}, 1, new int[]{1}, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        L:
        for (int i = 0; i < n; i++) {
            while (j < m + i) {
                if (nums2[i] <= nums1[j]) {
                    int temp = nums1[j];
                    nums1[j] = nums2[i];
                    for (int l = m + i - 1; l >= j; l--) {
                        nums1[l + 1] = nums1[l];
                    }
                    nums1[++j] = temp;
                    continue L;
                } else {
                    j++;
                }
            }
            while (i < n) {
                nums1[j++] = nums2[i++];
            }
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[m + n];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                num[index++] = nums1[i++];
            } else {
                num[index++] = nums2[j++];
            }
        }
        while (i < m) {
            num[index++] = nums1[i++];
        }
        while (j < n) {
            num[index++] = nums2[j++];
        }
        System.arraycopy(num, 0, nums1, 0, num.length);
    }
}
