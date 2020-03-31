package com.yunhui.thread.producer_consumer;

import lombok.Data;

/**
 * @Date : 2019-06-18 17:49
 * @Author :
 * @CopyRight :
 * @Desc :
 */
@Data
public class Resource {


    private int number;

    /**
     * true 代表有资源可消费  false 代表无资源可消费
     */
    private boolean flag;

    public synchronized void produce() {

        while (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"------>"+(++number));
        flag=true;
        notifyAll();
    }

    public synchronized void consume() {

        while (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"------>"+(number));
        flag=false;
        notifyAll();
    }

}
