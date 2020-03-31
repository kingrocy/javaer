package com.yunhui.java8.optional;

import java.util.Optional;

/**
 * @Date : 2019-06-24 09:30
 * @Author :
 * @CopyRight :
 * @Desc : Optional 基础用法
 */
public class Test {



    public static void main(String[] args) {

        /**
         * 区别  orElse一定会执行一次  orElseGet则不会
         */

        String value1 = Optional.ofNullable("test").map(Test::getNotNull).orElse(getNull());

        String value2 = Optional.ofNullable("test").map(Test::getNotNull).orElseGet(()->getNull());

        System.out.println(value1);

        System.out.println(value2);
    }

    private static String getNotNull(String args) {
        System.out.println("not null " + args);
        return "not null";
    }

    private static String getNull() {
        System.out.println("null");
        return "null";
    }


}
