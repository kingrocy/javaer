package com.yunhui.leetcode.easy;

/**
 * @Date : 2020/4/17 5:25 下午
 * @Author : dushaoyun
 * @desc 爬楼梯
 */
public class TaskClimbStairs {


    public int climbStairs(int n) {
        if(n<3){
            return n;
        }
        int a=1,b=2,tmp=0;
        for (int i = 3; i <=n ; i++) {
            tmp=b;
            b=a+b;
            a=tmp;
        }
        return b;
    }
}
