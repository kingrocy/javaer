package com.yunhui.base.sort;

/**
 * @Date : 2019-06-19 13:34
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class FastSort {

    //快速排序思想
    // 通过一趟排序将要排序的数据分割成独立的两部分，
    // 其中一部分的所有数据都比另外一部分的所有数据都要小，
    // 然后再按此方法对这两部分数据分别进行快速排序，
    // 整个排序过程可以递归进行，以此达到整个数据变成有序序列

    public static void main(String[] args) {
        int[] array = new int[]{9, 7, 3, 2, 4, 5, 6, 7, 8};
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] arr, int L, int R) {
        int i = L;
        int j = R;
        //支点
        int pivot = arr[(L + R) / 2];
        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j) {
            //寻找直到比支点大的数
            while (pivot > arr[i]) {
                i++;
            }
            //寻找直到比支点小的数
            while (pivot < arr[j]) {
                j--;
            }
            //此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        //上面一个while保证了第一趟排序支点的左边比支点小，支点的右边比支点大了。
        //“左边”再做排序，直到左边剩下一个数(递归出口)
        if (L < j) {
            quickSort(arr, L, j);
        }
        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if (i < R) {
            quickSort(arr, i, R);
        }
    }
}
