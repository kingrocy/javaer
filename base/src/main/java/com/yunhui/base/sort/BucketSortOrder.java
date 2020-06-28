package com.yunhui.base.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Date : 2020/6/28 11:20 上午
 * @Author : dushaoyun
 * @desc 桶排序  将一个非常大的订单根据金额进行排序
 *
 * 衍生方法：比如一个100G的文件 如何在有限的内存下对其进行排序
 *
 * 将文件划分成多个小文件 文件中的元素按照特定的映射方法映射到各个小文件
 *
 * 对小文件进行排序
 *
 * 汇总到大文件
 *
 * 排序完成
 */
public class BucketSortOrder {


    public static void main(String[] args) {
        int length = 10000;
        int[] array = new int[length];
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = rand.nextInt(10000) + 1;
        }
        // 100 数据，10 个桶
        BucketSortOrder.sort(array, 100);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 桶排序
     * 场景：将一个非常大的订单根据金额进行排序
     *
     * @param arr
     * @param bucketSize 桶大小
     */
    public static void sort(int[] arr, int bucketSize) {

        //桶的数量的设置
        int bucketCount = arr.length % bucketSize == 0 ? arr.length / bucketSize : arr.length / bucketSize + 1;

        int[][] buckets = new int[bucketCount][bucketSize];

        //记录每个桶里面的当前元素个数
        int[] bucketIndex = new int[bucketCount];

        //获取订单金额的最大值和最小值
        int min = arr[0];
        int max = arr[arr.length - 1];
        for (int i : arr) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        for (int i : arr) {
            //映射函数的编写 如何将数据均匀的映射到桶里
            //这里可以采用这种方法：通过订单的金额  假如10个桶  订单金额 1-100  那就是 1 【1-10】 2【2-20】 3【20-30】
            //此处使用max + 1是为了避免 当i=max时，计算的桶 index会数组越界
            int index = (i - min) * bucketCount / (max + 1 - min);
            //需要考虑扩容  因为元素可能分配不均匀
            if (bucketIndex[index] == buckets[index].length) {
                //扩容
                int[] temp = new int[buckets[index].length * 2];
                System.arraycopy(buckets[index], 0, temp, 0, buckets[index].length);
                buckets[index] = temp;
            }
            buckets[index][bucketIndex[index]++] = i;
        }

        //对每个桶进行快速排序
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            int[] bucket = buckets[i];
            //此处注意：不能对整个数组进行排序 我们只需要对数组有值的一部分进行排序即可
            FastSort.quickSort(bucket, 0, bucketIndex[i] - 1);
            //将数组有值的一部分 赋值到数组中
            for (int j = 0; j < bucketIndex[i]; j++) {
                arr[k++] = bucket[j];
            }
        }
    }


}
