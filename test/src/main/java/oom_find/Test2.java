package oom_find;

import java.util.concurrent.CompletableFuture;

/**
 * @Date : 2020/10/23 9:47 上午
 * @Author : dushaoyun
 */
public class Test2 {


    public static void main(String[] args) {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {


            int i=10/0;

            return "hello world";

        });

        String join = stringCompletableFuture.join();

        System.out.println("join:"+join);


        while (true){

        }
    }
}
