package com.yunhui.leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Date : 2020/5/9 3:54 下午
 * @Author : dushaoyun
 */
public class TaskZeroEvenOdd {

    private int n;

    public TaskZeroEvenOdd(int n) {
        this.n = n;
    }

    private Semaphore semaphoreZero = new Semaphore(1);
    private Semaphore semaphoreEven = new Semaphore(0);
    private Semaphore semaphoreOdd = new Semaphore(0);

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int k = 1; k <= n; k++) {
            semaphoreZero.acquire();
            printNumber.accept(0);
            if (k % 2 == 0) {
                semaphoreOdd.release();
            } else {
                semaphoreEven.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {
            semaphoreEven.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i + 2) {
            semaphoreOdd.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }


    public static void main(String[] args) {

        TaskZeroEvenOdd taskZeroEvenOdd = new TaskZeroEvenOdd(200);

        Thread thread1 = new Thread(() -> {
            try {
                taskZeroEvenOdd.zero(x -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                taskZeroEvenOdd.even(x -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                taskZeroEvenOdd.odd(x -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
