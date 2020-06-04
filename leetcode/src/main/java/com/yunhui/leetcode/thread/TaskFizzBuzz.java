package com.yunhui.leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Date : 2020/5/21 3:55 下午
 * @Author : dushaoyun
 */
public class TaskFizzBuzz {

    private int n;

    public TaskFizzBuzz(int n) {
        this.n = n;
    }

    private Semaphore semaphore1 = new Semaphore(0);
    private Semaphore semaphore2 = new Semaphore(0);
    private Semaphore semaphore3 = new Semaphore(0);
    private Semaphore semaphore4 = new Semaphore(1);


    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        semaphore1.acquire();
        printFizz.run();
        semaphore4.release();
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        semaphore2.acquire();
        printBuzz.run();
        semaphore4.release();
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        semaphore3.acquire();
        printFizzBuzz.run();
        semaphore4.release();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        int start = 1;
        while (start <= n) {
            semaphore4.acquire();
            if (start % 3 == 0 && start % 5 == 0) {
                semaphore3.release();
            } else if (start % 3 == 0) {
                semaphore1.release();
            }else if(start % 5 == 0){
                semaphore2.release();
            }else{
                printNumber.accept(start);
                semaphore4.release();
            }
            start++;
        }
    }
}
