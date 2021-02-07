package com.yunhui.leetcode.array;

/**
 * @Date : 2021/2/7 9:08 上午
 * @Author : dushaoyun
 * @desc : 翻转数组
 */
public class KuaiShouArray {


    public static void revertArray(int n, int m, int[] array) {
        if (m <= 0) {
            return;
        }
        if (m >= n) {
            //是否要抛异常
        }
        //暴力方法 每次移动一个元素 然后遍历m次
        int temp = array[n - 1];
        for (int i = 1; i <= m; i++) {
            for (int j = n - 2; j >= 0; j--) {
                array[j + 1] = array[j];
            }
            array[0] = temp;
            temp = array[n - 1];
        }
        //时间复杂度是 o(n*m)

        //有没有更好的方案了？
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,5,6};
        revertArray(6, 2, a);
        for (int i : a) {
            System.out.println(i);
        }
    }

}
