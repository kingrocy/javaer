package com.yunhui.leetcode.array;

/**
 * @Date : 2021/2/7 3:35 下午
 * @Author : dushaoyun
 * @desc https://leetcode-cn.com/problems/rotate-image/
 */
public class RotateImage {

    /**
     * 先水平翻转 再对角线翻转
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int start = 0;
        int end = n - 1;
        //水平翻转
        while (start < end) {
            for (int i = 0; i < matrix[start].length; i++) {
                int temp = matrix[start][i];
                matrix[start][i] = matrix[end][i];
                matrix[end][i] = temp;
            }
            start++;
            end--;
        }
        // 主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
}
