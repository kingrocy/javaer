package com.yunhui.thread.syn_container;

/**
 * @Date : 2019-06-19 09:23
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Main {


    //https://blog.csdn.net/weixin_42486373/article/details/84064178

    public static void main(String[] args) {

        Container container=new Container();

        Thread producer1 = new Thread(new Producer(container));
        Thread producer2 = new Thread(new Producer(container));
        Thread producer3 = new Thread(new Producer(container));
        Thread producer4 = new Thread(new Producer(container));
        Thread producer5 = new Thread(new Producer(container));



        Thread consumer1 = new Thread(new Consumer(container));
        Thread consumer2 = new Thread(new Consumer(container));
        Thread consumer3 = new Thread(new Consumer(container));
        Thread consumer4 = new Thread(new Consumer(container));
        Thread consumer5 = new Thread(new Consumer(container));
        Thread consumer6 = new Thread(new Consumer(container));
        Thread consumer7 = new Thread(new Consumer(container));
        Thread consumer8 = new Thread(new Consumer(container));
        Thread consumer9 = new Thread(new Consumer(container));
        Thread consumer10 = new Thread(new Consumer(container));

        producer1.setName("生产者1");
        producer2.setName("生产者2");
        producer3.setName("生产者3");
        producer4.setName("生产者4");
        producer5.setName("生产者5");


        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();


        consumer1.setName("消费者1");
        consumer2.setName("消费者2");
        consumer3.setName("消费者3");
        consumer4.setName("消费者4");
        consumer5.setName("消费者5");
        consumer6.setName("消费者6");
        consumer7.setName("消费者7");
        consumer8.setName("消费者8");
        consumer9.setName("消费者9");
        consumer10.setName("消费者10");



        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();
        consumer6.start();
        consumer7.start();
        consumer8.start();
        consumer9.start();
        consumer10.start();
    }


    public static class Producer implements Runnable{

        private Container container;

        public Producer(Container container){
            this.container=container;
        }

        @Override
        public void run() {
            while (true){
                container.put();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static class Consumer implements Runnable{

        private Container container;

        public Consumer(Container container){
            this.container=container;
        }

        @Override
        public void run() {
            while (true){
                container.get();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
