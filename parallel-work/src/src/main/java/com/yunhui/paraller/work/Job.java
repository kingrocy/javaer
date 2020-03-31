package com.yunhui.paraller.work;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Date : 2019-12-05 16:41
 * @Author :
 * @CopyRight :
 * @Desc :
 */
@Data
@AllArgsConstructor
public class Job {

    private Integer id;
    private String name;
    /**
     * 依赖的jobids
     */
    private List<Integer> dependIds;
    /**
     * 是否被依赖
     */
    private Boolean depended;
    /**
     * 是否被执行 加volatile的原因是  某个任务可能被多个任务依赖  需要加锁和volatile保证任务被唯一触发执行一次
     */
    private volatile Boolean executed;
}
