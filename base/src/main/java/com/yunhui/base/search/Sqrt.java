package com.yunhui.base.search;

/**
 * @Date : 2021/1/7 2:58 下午
 * @Author : dushaoyun
 */
public class Sqrt {


    public static double sqrt(int number) {
        double left = 1.4;
        double right = 1.5;
        double diff = 0.0000000001;
        while (right - left > diff) {
            double n = (right + left) / 2;
            double p = n * n;
            if (p > number) {
                right=n;
            } else if (p < number) {
                left=n;
            } else {
                return n;
            }
        }
        return (right + left) / 2;
    }


    public static void main(String[] args) {
        System.out.println(sqrt(2));
        System.out.println(Math.sqrt(2));
    }
}
