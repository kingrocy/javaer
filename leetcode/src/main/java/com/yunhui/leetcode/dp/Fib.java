package com.yunhui.leetcode.dp;

/**
 * @Date : 2020/5/25 9:26 上午
 * @Author : dushaoyun
 */
public class Fib {

    public int fib(int n) {
        return helper(new int[n + 1], n);
    }

    private int helper(int[] dptable, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (dptable[n] != 0) {
            return dptable[n];
        }
        dptable[n] = helper(dptable, n - 1) + helper(dptable, n - 2);
        return dptable[n];
    }

    public static void main(String[] args) {
        //递归写法
        Fib fib = new Fib();
        System.out.println(fib.fib(3));
        System.out.println(fib.fib(4));
        System.out.println(fib.fib(5));

        System.out.println(fib.fib2(6));
        System.out.println(fib.fib2(7));
        System.out.println(fib.fib2(8));
    }


    public int fib2(int n) {
        int[] memo = new int[n + 1];
        memo[1] = memo[2] = 1;
        for (int i = 3; i <= n; i++) {
            memo[i]=memo[i-1]+memo[i-2];
        }
        return memo[n];
    }

}
