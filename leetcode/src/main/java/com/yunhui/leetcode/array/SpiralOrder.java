package com.yunhui.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date : 2021/2/16 2:38 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/spiral-matrix/
 * @desc 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class SpiralOrder {

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> order = new ArrayList();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return order;
            }
            int top = 0;
            int bottom = matrix.length - 1;
            int left = 0;
            int right = matrix[0].length - 1;
            while (left <= right && top <= bottom) {
                //从左到右  [top,left] -> [top,right]
                for (int column = left; column <= right; column++) {
                    order.add(matrix[top][column]);
                }
                //从右到下  [top+1,right] -> [bottom,right]
                for (int row = top + 1; row <= bottom; row++) {
                    order.add(matrix[row][right]);
                }
                if (left < right && top < bottom) {
                    //从右下 到左下  [bottom,right-1] -> [bottom,left]
                    for (int column = right - 1; column >= left; column--) {
                        order.add(matrix[bottom][column]);
                    }
                    //从左下 到左上 [bottom-1,left]  ->[top+1,left]
                    for (int row = bottom - 1; row >= top + 1; row--) {
                        order.add(matrix[row][left]);
                    }
                }
                top++;
                left++;
                bottom--;
                right--;
            }
            return order;
        }
    }
}
