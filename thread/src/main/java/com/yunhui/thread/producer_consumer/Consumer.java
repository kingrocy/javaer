package com.yunhui.thread.producer_consumer;

/**
 * @Date : 2019-06-18 16:57
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Consumer implements Runnable{

    private Resource resource;


    public Consumer(Resource resource){
        this.resource=resource;
    }


    @Override
    public void run() {
        while (true){
            resource.consume();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}