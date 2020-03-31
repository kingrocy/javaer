package com.yunhui.thread.run_exception_catch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date : 2019-07-18 16:15
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService service= Executors.newFixedThreadPool(5);

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            service.execute(()->{
                System.out.println("hello");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


    }
}
