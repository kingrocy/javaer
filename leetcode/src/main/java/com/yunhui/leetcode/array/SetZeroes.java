package com.yunhui.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Date : 2020/8/3 10:05 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/zero-matrix-lcci/
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        Set<Integer> iset = new HashSet<>();
        Set<Integer> jset = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    iset.add(i);
                    jset.add(j);
                }
            }
        }
        for (Integer i : iset) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (Integer j : jset) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }

}
