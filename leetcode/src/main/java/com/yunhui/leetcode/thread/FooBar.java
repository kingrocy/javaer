package com.yunhui.leetcode.thread;

import java.util.concurrent.Semaphore;

/**
 * @Date : 2020/5/8 4:03 下午
 * @Author : dushaoyun
 */
public class FooBar {

    private int n;

    private Semaphore foo=new Semaphore(1);
    private Semaphore bar=new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }
}
