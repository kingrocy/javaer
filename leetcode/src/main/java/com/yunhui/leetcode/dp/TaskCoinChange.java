package com.yunhui.leetcode.dp;

/**
 * @Date : 2020/5/25 2:06 下午
 * @Author : dushaoyun
 */
public class TaskCoinChange {

    public int coinChange(int[] coins, int amount) {
//        int[] table = new int[amount + 1];
////        return dp(coins, table, amount);
        return dbTableFor(coins, amount);
    }

    /**
     * 自上而下
     *
     * @param coins
     * @param table
     * @param n
     * @return
     */
    public int dp(int[] coins, int[] table, int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        if (table[n] != 0) {
            return table[n];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp(coins, table, n - coin);
            if (sub == -1) {
                continue;
            }
            res = Integer.min(res, 1 + sub);
        }
        table[n] = res == Integer.MAX_VALUE ? -1 : res;
        return table[n];
    }

    /**
     * 自下而上递推
     *
     * @param coins
     * @param amount
     * @return
     */
    public int dbTableFor(int[] coins, int amount) {
        int[] table = new int[amount + 1];
        for (int i = 0; i <table.length; i++) {
            table[i]=amount+1;
        }
        table[0]=0;
        for (int i = 1; i < table.length; i++) {
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                table[i] = Integer.min(table[i], 1 + table[i - coin]);
            }
        }
        return table[amount] == amount+1 ? -1 : table[amount];
    }

    public static void main(String[] args) {
        TaskCoinChange taskCoinChange=new TaskCoinChange();

        taskCoinChange.coinChange(new int[]{1,2,5}, 11);
    }

}
