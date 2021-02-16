package com.yunhui.leetcode;

/**
 * @Date : 2021/2/13 8:39 下午
 * @Author : dushaoyun
 */
public class CountPrimes {

    public int countPrimes(int n) {
        int nums = 0;
        for (int i = 2; i < n; i++) {
            nums += isPrime(i) ? 1 : 0;
        }
        return nums;
    }

    /**
     * 判断一个数是否是质数
     * <p>
     * 质数的定义：对于大于1的自然数，除了1和它自身 没有其他的因数 这种数就是质数
     *
     * @param n
     * @return
     */
    public boolean isPrime(int n) {
        for (int i = 2; i < n && i != n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
