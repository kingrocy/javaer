package com.yunhui.thread.forkjoinpool;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;

/**
 * @Date : 2019-08-29 13:35
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class ForkJoinPoolDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        File file = new File("/Users/dushaoyun/work/workspace/java");
        long start = System.currentTimeMillis();
        long length = getFileCount(file);
        System.err.println("noForkJoin ----> 文件数目"+length);
        System.err.println( "noForkJoin ----> 耗时" + (System.currentTimeMillis() - start) + "ms");


        java.util.concurrent.ForkJoinPool forkJoinPool=new java.util.concurrent.ForkJoinPool(4);

        long start2 = System.currentTimeMillis();

        Long length2 = forkJoinPool.submit(() -> getFileCount(file)).join();

        System.err.println("ForkJoin ----> 文件数目"+length2);
        System.err.println( "ForkJoin ----> 耗时" + (System.currentTimeMillis() - start2) + "ms");


        long start3 = System.currentTimeMillis();
        ForkJoinPool forkJoinPool2 = new ForkJoinPool(4);
        CustomTask customTask = new CustomTask(file);
        Future future = forkJoinPool2.submit(customTask);
        try {
            System.err.println("forkJoin2 -----> 文件数目" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.err.println( "forkJoin2 -----> 耗时" + (System.currentTimeMillis() - start3) + "ms");


    }


    private static long getFileCount(File file){
        long count = 0;
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()){
                count += getFileCount(files[i]);
            }else {
                count ++;
            }
        }
        return count;
    }
}
