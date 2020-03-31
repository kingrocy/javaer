package com.yunhui.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Date : 2019-07-29 17:10
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Main{


    public static void main(String[] args) {

        /**
         * 声明4个许可证
         */
        Semaphore semaphore=new Semaphore(4);

        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i <10 ; i++) {
            service.execute(()->{
                try {
                    /**
                     * 获取许可 如果获取不到 则会进入阻塞
                     */
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String threadName=Thread.currentThread().getName();
                System.out.println(threadName+"---- hello");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                semaphore.release();

            });
        }

    }


}
