package com.yunhui.base.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Date : 2020/6/28 2:29 下午
 * @Author : dushaoyun
 */
public class BucketSort2 {

    public static void main(String[] args) {
        int length = 100;
        int[] array = new int[length];
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = rand.nextInt(10000) + 1;
        }
        // 100 数据，10 个桶
        int[] sort = BucketSort2.sort(array, 100);
        System.out.println(Arrays.toString(sort));
    }

    public static int[] sort(int[] sourceArray, int bucketSize) {
        // 找出最大、最小值
        int minValue = sourceArray[0];
        int maxValue = sourceArray[1];
        for (int value : sourceArray) {
            minValue = Math.min(minValue, value);
            maxValue = Math.max(maxValue, value);
        }
        // 桶数量 桶数量的计算有问题 不能这样子
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        // 保存每个桶的数组的元素下标，默认值 0
        int[] indexArr = new int[bucketCount];

        // 将数组中值分配到各个桶里
        for (int value : sourceArray) {
            int bucketIndex = (value - minValue) / bucketSize;
            // 当前桶的数组达到最大值,需要拓容
            if (indexArr[bucketIndex] == buckets[bucketIndex].length) {
                ensureCapacity(buckets, bucketIndex);
            }
            // 将数据放到桶中，并且桶对应的数组下标 + 1
            buckets[bucketIndex][indexArr[bucketIndex]++] = value;
        }

        // 对每个桶进行排序，这里使用了快速排序
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (indexArr[i] == 0) {
                continue;
            }
            // 默认容量是 bucketSize, 要根据实际桶的容量排序，否则不足 bucketSize 的默认值是 0
            FastSort.quickSort(buckets[i], 0, indexArr[i] - 1);
            for (int j = 0; j < indexArr[i]; j++) {
                sourceArray[k++] = buckets[i][j];
            }
        }
        return sourceArray;
    }

    /**
     * 数组扩容,并保存数据
     *
     * @param buckets
     * @param bucketIndex
     */
    private static void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }
}
