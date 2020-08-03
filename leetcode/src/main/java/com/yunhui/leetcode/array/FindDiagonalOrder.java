package com.yunhui.leetcode.array;

/**
 * @Date : 2020/7/24 9:35 上午
 * @Author : dushaoyun
 */
public class FindDiagonalOrder {

    public static void main(String[] args) {
        FindDiagonalOrder order = new FindDiagonalOrder();
        int[][] matrix = new int[3][3];
        int index = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = index++;
            }
        }
        int[] diagonalOrder = order.findDiagonalOrder(matrix);
        for (int i : diagonalOrder) {
            System.out.println(i);
        }
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;

        boolean up = true;

        int i = 0, j = 0;

        while (!(i == matrix.length - 1 && j == matrix[0].length - 1)) {
            //遍历
            if (up) {
                //向上遍历
                L1:
                while (i >= 0 && j <= matrix[i].length - 1) {
                    res[index++] = matrix[i][j];
                    if (i == 0 || j == matrix[i].length - 1) {
                        break L1;
                    } else {
                        i--;
                        j++;
                    }

                }
            } else {
                //向下遍历
                L2:
                while (j >= 0 && i <= matrix.length - 1) {
                    res[index++] = matrix[i][j];
                    if (j == 0 || i == matrix.length - 1) {
                        break L2;
                    }
                    i++;
                    j--;
                }
            }

            //改变方向
            if (up) {
                //如果从上升 改成下降
                //变成向下转弯时 有两种变化 当i=0时  j++   当j=length-1 时 i++
                if (j == matrix[i].length - 1) {
                    i++;
                } else if (i == 0) {
                    j++;
                }
                up = false;
            } else {
                //从下降改成上升  当j==0  i++  当i=leng-1  j++
                if (i == matrix.length - 1) {
                    j++;
                } else if (j == 0) {
                    i++;
                }
                up = true;
            }

        }
        res[index++]=matrix[i][j];
        return res;
    }
}
