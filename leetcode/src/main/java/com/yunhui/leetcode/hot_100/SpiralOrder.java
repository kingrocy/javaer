package com.yunhui.leetcode.hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2024-02-02
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int left = 0;
        int right = matrix[0].length - 1;

        int top = 0;
        int bottom = matrix.length - 1;

        int m = 0;
        int n = 0;



        return null;
    }
}
