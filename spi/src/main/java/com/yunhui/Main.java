package com.yunhui;

import java.util.ServiceLoader;

/**
 * @Date : 2019-09-11 15:15
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Main {


    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);

        serviceLoader.forEach(Robot::sayHello);
    }
}
