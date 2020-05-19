package com.yunhui.leetcode.easy;

/**
 * @Date : 2020/4/9 5:28 下午
 * @Author : dushaoyun
 * @Link https://leetcode-cn.com/problems/sqrtx/
 */
public class TaskMySqrt {

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        long num;
        int pivot;
        int left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long) pivot * pivot;
            if (num > x){
                right = pivot - 1;
            } else if (num < x) {
                left = pivot + 1;
            } else{
                return pivot;
            }

        }
        return right;
    }
}
