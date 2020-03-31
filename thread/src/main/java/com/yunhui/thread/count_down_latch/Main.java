package com.yunhui.thread.count_down_latch;
import java.time.Year;
import java.util.Random;
import java.util.RandomAccess;
import java.util.concurrent.CountDownLatch;

/**
 * @Date : 2019-07-29 16:53
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Main {


    public static void main(String[] args) {

        /**
         * 计数器初始化为1 当减为0时 就会唤醒 所有await的进程
         */
        CountDownLatch countDownLatch=new CountDownLatch(4);


        new Thread(()->{
            while (true){
                if(countDownLatch.getCount()==0){
                    break;
                }
                double random = Math.random();
                int y = (int)(random * 1000);
                System.out.println("y:"+y);
                if(y%7==0){
                    countDownLatch.countDown();
                    continue;
                }
            }
        }).start();

        System.out.println("wait...");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("release..."+countDownLatch.getCount());



    }


}
