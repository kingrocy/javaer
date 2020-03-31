package com.yunhui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Date : 2020-01-09 10:08
 * @Author : dushaoyun
 */
public class DelayQueueTest {


    public static void main(String[] args) throws InterruptedException {


        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Item item1=new Item("dusy",10, TimeUnit.SECONDS);

        Item item2=new Item("whh",15,TimeUnit.SECONDS);

        DelayQueue<Item> delayQueue = new DelayQueue<>();

        delayQueue.add(item1);
        delayQueue.add(item2);

        /**
         * 取出头节点  但并不删除     是非阻塞的吗
         */
        Item peek1 = delayQueue.peek();
        System.out.println(sdf.format(new Date())+":"+peek1);
        Item peek2 = delayQueue.peek();
        System.out.println(sdf.format(new Date())+":"+peek2);


        /**
         * 取出并删除头结点    非阻塞
         */
        Item poll = delayQueue.poll();
        System.out.println(sdf.format(new Date())+":"+poll);

        /**
         * 阻塞的取出并删除头节点
         */
        while (true){
            Item take = delayQueue.take();
            System.out.println(sdf.format(new Date())+":"+take);
        }

    }
}
