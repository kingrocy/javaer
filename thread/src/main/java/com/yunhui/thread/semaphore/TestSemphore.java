package com.yunhui.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @Date : 2020/1/14 11:24 上午
 * @Author : dushaoyun
 */
public class TestSemphore {

    public static void main(String[] args) {
        TestSemphore print = new TestSemphore();
        print.print1();
    }

    public void print1() {
        //奇数信号量  打印偶数的线程负责释放
        Semaphore jsemaphore = new Semaphore(1);
        //偶数信号量  打印奇数的线程负责释放
        Semaphore osemaphore = new Semaphore(0);
        new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 1) {
                    try {
                        jsemaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                    osemaphore.release();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 0) {
                    try {
                        osemaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                    jsemaphore.release();
                }
            }
        }).start();
    }

}
