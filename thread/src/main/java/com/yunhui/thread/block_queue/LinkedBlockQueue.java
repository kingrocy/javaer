package com.yunhui.thread.block_queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Date : 2019-07-08 17:43
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class LinkedBlockQueue {

     static LinkedBlockingQueue<Integer> queue=new LinkedBlockingQueue<>(10);


    public static void main(String[] args) {

        AtomicInteger a=new AtomicInteger(0);


        new Thread(()->{
            while (true){
                try {
                    queue.put(a.incrementAndGet());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        ExecutorService service= Executors.newFixedThreadPool(2);
        for (int i=0;i<10;i++){
            service.submit(()->{
                while (true){
                    String threadNamne = Thread.currentThread().getName();
                    try {
                        System.out.println(threadNamne+"----take----"+queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        new Thread(()->{
            while (true){
                System.out.println("queue size=========>>>"+queue.size());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
