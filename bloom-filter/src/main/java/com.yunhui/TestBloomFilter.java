package com.yunhui;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @Date : 2020/6/3 2:29 下午
 * @Author : dushaoyun
 */
public class TestBloomFilter {

    private static int total = 1000000;
    private static BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), total);
//    private static BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), total, 0.001);

    /**
     funnel：数据类型(一般是调用Funnels工具类中的)

     expectedInsertions：期望插入的值的个数

     fpp 错误率(默认值为0.03)

     strategy 哈希算法(我也不懂啥意思)Bloom Filter的应用

     * @param args
     */

    public static void main(String[] args) {
        // 初始化1000000条数据到过滤器中
        for (int i = 0; i < total; i++) {
            bf.put(i);
        }

        // 匹配已在过滤器中的值，是否有匹配不上的
        for (int i = 0; i < total; i++) {
            if (!bf.mightContain(i)) {
                System.out.println("有坏人逃脱了~~~");
            }
        }

        // 匹配不在过滤器中的10000个值，有多少匹配出来
        int count = 0;
        for (int i = total; i < total + 10000; i++) {
            if (bf.mightContain(i)) {
                count++;
            }
        }
        System.out.println("误伤的数量：" + count);
    }
}
