package com.yunhui.leetcode.thread;

import java.util.concurrent.Semaphore;

/**
 * @Date : 2020/5/9 4:37 下午
 * @Author : dushaoyun
 */
public class TaskH2O {


    public TaskH2O() {

    }

    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        releaseOxygen.run();
        h.release(2);
    }

}
