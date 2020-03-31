package com.yunhui.base.sort;

/**
 * @Date : 2019-06-19 14:36
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class SortAnalyze {


    /**
     *
     * 冒泡排序和快速排序的性能测试
     *
     * 一个100000大小无序整型数组
     *
     * 冒泡需要 19秒多
     *
     * 而快排 只需要 0.028s
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        int len=100000;

        int [] array=new int[len];

        int [] array2=new int[len];

        for (int i=0;i<len;i++){

            int randonInt=(int)(Math.random()*len);

            array[i]=randonInt;
            array2[i]=randonInt;
        }

//        long startTime=System.currentTimeMillis();
//
//        BubbleSort.sort(array);
//
//        long endTime=System.currentTimeMillis();
//
//        //冒泡排序话费时间:19.736
//
//        System.out.println("冒泡排序话费时间:"+(endTime-startTime)/1000.0);
//

        long startTime2=System.currentTimeMillis();

        FastSort.sort(array2,0,array2.length-1);

        long endTime2=System.currentTimeMillis();

        System.out.println("快速排序话费时间:"+(endTime2-startTime2)/1000.0);

        for (int i : array2) {
            System.out.println(i);
        }

    }
}
