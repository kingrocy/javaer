package com.yunhui.base.sort;

/**
 * @Date : 2019-06-19 11:18
 * @Author :
 * @CopyRight :
 * @Desc : 冒泡排序
 */
public class BubbleSort {


    public static void main(String[] args) {

        int [] array=new int[]{1,3,6,2,7,4,5};

        sort(array);

        for (int i : array) {
            System.out.println(i);
        }

    }

    public static void sort(int [] array){
        for (int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    array[i]=array[i]^array[j];
                    array[j]=array[i]^array[j];
                    array[i]=array[i]^array[j];
                }
            }
        }
    }

}
