package com.yunhui.thread.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Date : 2021/2/8 2:52 下午
 * @Author : dushaoyun
 */
public class ThreadPoolTest {

    ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder().setNameFormat("test-%s")
            .setUncaughtExceptionHandler((t, e) -> {
                if (e != null) {
                    System.out.println(t.getName()+" execute "+"occur exception,error:" + e.getClass().getName());
                }
            });

    ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 5,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(10),
            threadFactoryBuilder.build(),
            new ThreadPoolExecutor.AbortPolicy());


    public static void main(String[] args) {
        ThreadPoolTest threadPoolTest=new ThreadPoolTest();
        threadPoolTest.executor.execute(()->{
            System.out.println("execute...");
            System.out.println(10/0);
        });

        Future<String> future = threadPoolTest.executor.submit(() -> {
            System.out.println("submit...");
            System.out.println(10 / 0);
            return "success";
        });

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        while (true){

        }
    }


}
