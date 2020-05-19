package com.yunhui.leetcode.thread;

import java.util.concurrent.Semaphore;

/**
 * @Date : 2020/5/8 3:47 下午
 * @Author : dushaoyun
 */
public class Foo {


    private Semaphore semaphore1 = new Semaphore(0);
    private Semaphore semaphore2 = new Semaphore(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        semaphore1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore1.acquire();
        printSecond.run();
        semaphore2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore2.acquire();
        printThird.run();
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);
        semaphore.release();
        System.out.println(semaphore.availablePermits());
    }
}
