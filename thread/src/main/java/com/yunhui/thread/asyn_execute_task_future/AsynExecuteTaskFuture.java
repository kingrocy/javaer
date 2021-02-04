package com.yunhui.thread.asyn_execute_task_future;

import java.util.concurrent.*;

/**
 * @Date : 2021/2/4 9:24 上午
 * @Author : dushaoyun
 */
public class AsynExecuteTaskFuture {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));


        Future<String> future1 = executor.submit(() -> {
            Thread.sleep(1000);
            return "say hello1";
        });


        Future<String> future2 = executor.submit(() -> {
            Thread.sleep(1000);
            return "say hello2";
        });

        Future<String> future3 = null;

        try {
            future3 = executor.submit(() -> {
                return "say hello3";
            });
        } catch (Exception e) {
        }

//        executor.execute();

        System.out.println(future3 == null);

        while (true) {

        }
    }
}
