package com.yunhui.arithmetic.funnel_limit;

import java.util.Random;

/**
 * @Date : 2020/10/22 10:06 上午
 * @Author : dushaoyun
 * @Desc ：漏斗限流
 * <p>
 * 场景：限制用户 每秒可以进行几次操作
 */
public class FunnelLimit {

    /**
     * 漏斗容量
     */
    private Integer total_capacity;

    /**
     * 剩余容量
     */
    private Integer left_capacity;


    /**
     * 漏斗流速(每秒腾出多少空间)
     */
    private Integer rateSpeedPerSecond;

    /**
     * 上一次操作时间 ms
     */
    private Long previousTimeStamp;

    public FunnelLimit(Integer total_capacity, Integer rateSpeedPerSecond) {
        this.total_capacity = total_capacity;
        this.left_capacity = total_capacity;
        this.rateSpeedPerSecond = rateSpeedPerSecond;
        this.previousTimeStamp = System.currentTimeMillis();
    }

    public Integer getLeftCapacity() {
        long now = System.currentTimeMillis();
        //计算上一次操作时间 与当前时间 间隔了多少秒
        long delta = (now - previousTimeStamp) / 1000;
        previousTimeStamp=now;
        //在这个间隔内 漏斗腾出的空间
        long rateCapacity = delta * rateSpeedPerSecond;
        long new_left_capacity = left_capacity + rateCapacity;
        if (new_left_capacity > total_capacity) {
            new_left_capacity = total_capacity;
        }
        System.out.println("当前操作与上一次操作间隔："+delta+" ，当前漏斗容量："+new_left_capacity);
        left_capacity = (int) new_left_capacity;
        return left_capacity;
    }


    public boolean tryOperat(int quota) {
        if (getLeftCapacity() >= quota) {
            left_capacity -= quota;
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        /**
         * 一个场景 限制每秒用户只可操作5次 那么新增一个容量为5，每秒流速为5的漏斗即可
         */
        FunnelLimit funnelLimit = new FunnelLimit(5, 5);

        new Thread(() -> {
            while (true) {
                boolean tryOperat = funnelLimit.tryOperat(1);
                if (tryOperat) {
                    System.out.println(System.currentTimeMillis() + ":当前成功操作一次");
                } else {
                    System.out.println(System.currentTimeMillis() + ":当前操作被禁止");
                }

                Random random = new Random();

                int anInt = random.nextInt(15);

                System.out.println("线程休眠："+anInt*100+" ms");

                System.out.println();
                System.out.println();
                System.out.println();
                try {
                    Thread.sleep(anInt*100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        while (true) {

        }
    }

}
