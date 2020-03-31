package com.yunhui.paraller.work;

import lombok.Data;

import java.util.List;

/**
 * @Date : 2019-12-05 15:10
 * @Author :
 * @CopyRight :
 * @Desc :
 */
@Data
public class FeatureTask {

    /**
     * 任务id
     */
    private Long id;
    /**
     * 任务输出的特征
     */
    private String outputName;
    /**
     * 任务依赖的特征
     */
    private List<String> inputs;
    /**
     * 依赖的任务id
     */
    private List<Long> dependId;
}
