package com.yunhui.thread.producer_consumer;

/**
 * @Date : 2019-06-18 16:56
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Main {

    public static void main(String[] args) {


        Resource resource=new Resource();

        Thread producer1=new Thread(new Producer(resource));
        Thread producer2=new Thread(new Producer(resource));
        Thread producer3=new Thread(new Producer(resource));

        producer1.setName("生产者1");
        producer2.setName("生产者2");
        producer3.setName("生产者3");

        Thread consumer1=new Thread(new Consumer(resource));
        Thread consumer2=new Thread(new Consumer(resource));

        consumer1.setName("消费者1");
        consumer2.setName("消费者2");

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();

    }


}
