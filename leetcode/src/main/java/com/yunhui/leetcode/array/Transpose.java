package com.yunhui.leetcode.array;

/**
 * @Date : 2021/2/7 4:17 下午
 * @Author : dushaoyun
 */
public class Transpose {

    public int[][] transpose(int[][] A) {
        int n = A.length;
        if (n == 0) {
            return A;
        }
        int m = A[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = A[j][i];
            }
        }
        return res;
    }

}
