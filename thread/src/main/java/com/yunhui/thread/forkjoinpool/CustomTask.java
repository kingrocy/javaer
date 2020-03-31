package com.yunhui.thread.forkjoinpool;

import java.io.File;
import java.util.concurrent.RecursiveTask;

/**
 * @Date : 2019-08-29 13:53
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public   class CustomTask extends RecursiveTask<Long> {

    private File file;

    public CustomTask(File file) {
        this.file = file;
    }

    @Override
    protected Long compute() {
        long count = 0L;
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {

                CustomTask customTask = new CustomTask(files[i]);
                customTask.fork();
                count += customTask.join();
            } else {
                count++;
            }
        }
        return count;
    }
}