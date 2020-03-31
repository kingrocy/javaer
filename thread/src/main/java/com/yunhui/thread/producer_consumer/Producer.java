package com.yunhui.thread.producer_consumer;

/**
 * @Date : 2019-06-18 16:56
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Producer implements Runnable{


    private Resource resource;


    public Producer(Resource resource){
        this.resource=resource;
    }


    @Override
    public void run() {
        while (true){
            resource.produce();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
