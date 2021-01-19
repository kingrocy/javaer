package com.yunhui.leetcode;

import java.math.BigInteger;

/**
 * @Date : 2021/1/19 10:01 上午
 * @Author : dushaoyun
 * @desc 给定一个数，求出一个数的阶乘末尾有多少个 0。
 * @link https://leetcode-cn.com/problems/factorial-trailing-zeroes
 */
public class TrailingZeroes {

    public static int trailingZeroes(int n) {
        BigInteger trailing = new BigInteger("1");
        while (n > 0) {
            trailing = trailing.multiply(new BigInteger(n + ""));
            n--;
        }
        int trailingZeroes = 0;
        while (trailing.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            trailing = trailing.divide(BigInteger.TEN);
            trailingZeroes++;
        }
        return trailingZeroes;
    }

    /**
     * 阶乘末尾有多少个0  取绝于 有多少个 2*5的对
     * <p>
     * 根据分析 11! = 11 * 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
     * = 11 * (2 * 5) * 9 * (4 * 2) * 7 * (3 * 2) * (1 * 5) * (2 * 2) * 3 * (1 * 2) * 1
     * 如上 我们可以清晰的得知 出现2的因子 远超于5 所以我们只需要统计5的因子个数 就能得知阶乘后有多少个0
     *
     * @param n
     * @return
     */
    public int trailingZeroes2(int n) {
        int trailingZeroes = 0;
        for (int i = 1; i <= n; i++) {
            int k = i;
            while (k > 0) {
                if (k % 5 == 0) {
                    trailingZeroes++;
                    k /= 5;
                } else {
                    break;
                }
            }
        }
        return trailingZeroes;
    }

}
