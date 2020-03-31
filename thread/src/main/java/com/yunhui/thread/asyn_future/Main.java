package com.yunhui.thread.asyn_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Date : 2019-07-29 16:26
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Main {


    public static String getA(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "A";
    }

    public static String getB(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "B";
    }

    public static String getC(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "C";
    }

    public static String getD(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "D";
    }

    public static void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(Main::getA);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(Main::getB);
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(Main::getC);
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(Main::getD);

        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
        System.out.println(future4.get());
    }

    public static void test2(){
        String a=getA();
        String b=getB();
        String c=getC();
        String d=getD();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime=System.currentTimeMillis();
        test1();
        long endTime=System.currentTimeMillis();
        System.out.println("test1 cost time:"+(endTime-startTime));

        long startTime1=System.currentTimeMillis();
        test2();
        long endTime2=System.currentTimeMillis();
        System.out.println("test2 cost time:"+(endTime2-startTime1));
    }
}
