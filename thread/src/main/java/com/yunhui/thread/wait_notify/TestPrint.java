package com.yunhui.thread.wait_notify;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Date : 2020/1/15 3:08 下午
 * @Author : dushaoyun
 */
public class TestPrint {

    public static void main(String[] args) {
        TestPrint print = new TestPrint();

        print.print();
    }


    public void print() {

        Object object=new Object();

        final AtomicInteger i=new AtomicInteger(1);

        new Thread(()->{

            while (i.get()<=100){
                synchronized (object){
                    if(i.get()%2==1){
                        System.out.println(i.getAndIncrement());
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }


        }).start();


        new Thread(()->{
            while (i.get()<=100){
                synchronized (object){
                    if(i.get()%2==0){
                        System.out.println(i.getAndIncrement());
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }

}
