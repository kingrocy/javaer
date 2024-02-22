package com.yunhui.leetcode.hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2024-01-31
 * https://leetcode.cn/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-100-liked
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = matrix[i];
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 0) {
                    left.add(i);
                    right.add(j);
                }
            }
        }
        //遍历 left、right 设置为0
        for (Integer index : left) {
            int[] arr = matrix[index];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 0;
            }
        }
        for (Integer index : right) {
            for (int[] arr : matrix) {
                arr[index] = 0;
            }
        }
    }
}
