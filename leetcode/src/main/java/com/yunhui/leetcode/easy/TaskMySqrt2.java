package com.yunhui.leetcode.easy;

/**
 * @Date : 2020/8/7 10:53 上午
 * @Author : dushaoyun
 */
public class TaskMySqrt2 {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 0;
        int right = x;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid > x) {
                right = mid - 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }


    public static int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

}
