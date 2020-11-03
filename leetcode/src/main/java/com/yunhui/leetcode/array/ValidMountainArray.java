package com.yunhui.leetcode.array;

/**
 * @Date : 2020/11/3 10:54 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/valid-mountain-array/
 */
public class ValidMountainArray {


    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{2, 1}));
        System.out.println(validMountainArray(new int[]{3, 5, 5}));
        System.out.println(validMountainArray(new int[]{0, 3, 2, 1}));
    }

    public static boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        //双指针模拟上山
        int left = 0;
        int right = A.length - 1;

        //先让左边的爬上去
        while (left < A.length - 1) {
            if (A[left + 1] > A[left]) {
                left++;
            } else if (A[left + 1] == A[left]) {
                return false;
            } else {
                break;
            }
        }
        //右边的
        while (right > 0) {
            if (A[right] < A[right - 1]) {
                right--;
            } else if (A[right] == A[right - 1]) {
                return false;
            } else {
                break;
            }
        }
        if (left == right) {
            //不能在山脚
            if (left == 0 || left == A.length - 1) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
