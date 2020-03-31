package com.yunhui.thread.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Date : 2019-08-29 15:00
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class ForkJoinPoolDemo3 {

    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//
//        Fibonacci fibonacci1 = new Fibonacci(200);
//        Integer compute = fibonacci1.compute();
//        long endTime = System.currentTimeMillis();
//
//        System.out.println("sum: " + compute + " in " + (endTime - startTime) + " ms.");


        ForkJoinPool forkJoinPool = new ForkJoinPool(4); // 最大并发数4
        Fibonacci fibonacci = new Fibonacci(200);
        long startTime2 = System.currentTimeMillis();
        Integer result = forkJoinPool.invoke(fibonacci);
        long endTime2 = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime2 - startTime2) + " ms.");
    }


    static  class Fibonacci extends RecursiveTask<Integer> {
        final int n;

        Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1) {
                return n;
            }
            Fibonacci f1 = new Fibonacci(n - 1);
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            return f2.compute() + f1.join();
        }

    }

}
