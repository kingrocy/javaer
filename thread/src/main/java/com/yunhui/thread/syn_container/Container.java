package com.yunhui.thread.syn_container;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date : 2019-06-19 10:25
 * @Author :
 * @CopyRight :
 * @Desc : 同步容器
 */
public class Container {

    private int max=20;

    private int min=0;


    private int num;

    private List<Object> list=new ArrayList<>();


    public synchronized void  put(){
        while (list.size()>=max){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(++num);
        System.out.println(Thread.currentThread().getName()+"生产----->"+num+",当前count:"+getCount());
        notifyAll();
    }


    public synchronized Object get(){
        while (list.size()<=min){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object obj = list.get(0);
        list.remove(0);
        System.out.println(Thread.currentThread().getName()+"消费----->"+obj+",当前count:"+getCount());
        notifyAll();
        return obj;
    }


    public int getCount(){
        return list.size();
    }


}
