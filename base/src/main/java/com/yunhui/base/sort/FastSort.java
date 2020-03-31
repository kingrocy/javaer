package com.yunhui.base.sort;

/**
 * @Date : 2019-06-19 13:34
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class FastSort {

    //快速排序思想
    //通过一趟排序将要排序的数据分割成独立的两部分，
    // 其中一部分的所有数据都比另外一部分的所有数据都要小，
    // 然后再按此方法对这两部分数据分别进行快速排序，
    // 整个排序过程可以递归进行，以此达到整个数据变成有序序列

    public static void main(String[] args) {
        int [] array=new int[]{1,3,6,2,7,4,5};

        sort(array,0,array.length-1);

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int [] a,int start,int end){

        int k=a[start];
        int i=start,j=end;
        if(i==j){
            return;
        }
        while (i<j){
            while (i<j&&a[j]>=k){
                j--;
            }
            a[i]=a[j];
            while (i<j&&a[i]<=k){
                i++;
            }
            a[j]=a[i];
        }
        a[i]=k;
        sort(a,start, i);
        sort(a, i+1, end);
    }


}
