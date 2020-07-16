package com.yunhui.base.sort;

/**
 * @Date : 2020/7/7 10:29 上午
 * @Author : dushaoyun
 */
public class InsertSort {

    /**
     * 插入排序，a表示数组，n表示数组大小
     * @param a
     * @param n
     */
    public static void insertionSort(int[] a, int n) {
        if (n <= 1){
            return;
        }
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // 数据移动
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            // 插入数据
            a[j+1] = value;
        }
    }

    public static void main(String[] args) {
        int [] array=new int[]{1,3,6,2,7,4,5};

        insertionSort(array,array.length);

        for (int i : array) {
            System.out.println(i);
        }
    }

}
