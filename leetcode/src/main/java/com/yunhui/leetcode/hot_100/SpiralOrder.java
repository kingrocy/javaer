package com.yunhui.leetcode.hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2024-02-02
 */
public class SpiralOrder {

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();

        int[][] matrix = new int[3][4];

        matrix[0] = new int[] {1, 2, 3, 4};
        matrix[1] = new int[] {5, 6, 7, 8};
        matrix[2] = new int[] {9, 10, 11, 12};

        List<Integer> integers = spiralOrder.spiralOrder(matrix);

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return list;
        }

        int left = 0;
        int right = matrix[0].length - 1;

        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {

            //先从左上到右上 [top,left]->[top,right]
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }

            //再从右上到右下 (top,right)->[bottom,right]
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }

            if (left < right && top < bottom) {
                //再从右下到左下 [bottom,right)->[bottom,left]
                for (int i = right - 1; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                //再从左下到左上  (bottom,left]->(top,left]
                for (int i = bottom - 1; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }

            left++;
            top++;
            right--;
            bottom--;
        }

        return list;
    }
}
