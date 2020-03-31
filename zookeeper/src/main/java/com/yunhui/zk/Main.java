package com.yunhui.zk;

import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * @Date : 2019-07-29 15:25
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class Main {


    public static void main(String[] args) {

        ZkClient zkClient=new ZkClient("118.25.172.253:2181",5000,100);
        List<String> children = zkClient.getChildren("/");

        for (String child : children) {
            System.out.println(child);
        }

        zkClient.close();
    }
}
