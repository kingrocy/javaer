package com.yunhui.thread.forkjoinpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

/**
 * @Date : 2019-08-29 13:58
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class ForkJoinPoolDemo2 {


    private static List<Integer> list=new ArrayList<>();


    static {

        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }

    }

    public static void main(String[] args) {

        long start1=System.currentTimeMillis();
        Map<Integer, Integer> map1 = list.stream().collect(Collectors.toMap(x -> x, x -> x));
        long end1=System.currentTimeMillis();
        System.out.println("串行流遍历数据："+(end1-start1)+" ms");

        long start2=System.currentTimeMillis();
        Map<Integer, Integer> map2 = list.parallelStream().collect(Collectors.toMap(x -> x, x -> x));
        long end2=System.currentTimeMillis();
        System.out.println("并行流遍历数据："+(end2-start2)+" ms");

        long start3=System.currentTimeMillis();
        Map<Integer, Integer> map3 = new ForkJoinPool(20).submit(() -> list.parallelStream().collect(Collectors.toMap(x -> x, x -> x))).join();
        long end3=System.currentTimeMillis();
        System.out.println("ForkJoinPool 遍历数据："+(end3-start3)+" ms");


    }
}
