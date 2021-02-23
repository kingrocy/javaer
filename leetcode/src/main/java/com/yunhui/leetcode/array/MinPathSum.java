package com.yunhui.leetcode.array;

/**
 * @Date : 2021/2/19 10:22 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/minimum-path-sum/
 * @desc 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinPathSum {


    /**
     * 创建二维数组 dp，与原始网格的大小相同，dp[i][j] 表示从左上角出发到 (i,j)(i,j) 位置的最小路径和。
     * <p>
     * 显然，dp[0][0]=grid[0][0]。对于 dp 中的其余元素，通过以下状态转移方程计算元素值。
     * <p>
     * 当 i>0 且 j=0 时，dp[i][0]=dp[i−1][0]+grid[i][0]。
     * <p>
     * 当 i=0 且 j>0 时，dp[0][j]=dp[0][j−1]+grid[0][j]。
     * <p>
     * 当 i>0 且 j>0 时，dp[i][j]=min(dp[i−1][j],dp[i][j−1])+grid[i][j]。
     * <p>
     * 最后得到 dp[m−1][n−1] 的值即为从网格左上角到网格右下角的最小路径和。
     *
     * @return
     */
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(grid));
    }
}
