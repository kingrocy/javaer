package com.yunhui.paraller.work;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Date : 2019-12-05 17:56
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class SerialExecute {


    public static void main(String[] args) {

        Job job1 = new Job(1, "A", Lists.newArrayList(2, 3), false, false);
        Job job2 = new Job(2, "B", Lists.newArrayList(4), true, false);
        Job job3 = new Job(3, "C", Lists.newArrayList(5), true, false);
        Job job4 = new Job(4, "D", Lists.newArrayList(), true, false);
        Job job5 = new Job(5, "E", Lists.newArrayList(), true, false);
        Job job6 = new Job(6, "F", Lists.newArrayList(), false, false);

        List<Job> jobs = Lists.newArrayList(job6, job5, job4, job3, job2, job1);

        Map<String, Integer> featureMap = Maps.newConcurrentMap();

        //job depend mapping
        Map<Integer, List<Integer>> jobDepIdsMap = jobs.parallelStream().collect(Collectors.toMap(Job::getId, Job::getDependIds));

        //job id mapping
        Map<Integer, Job> jobMap = jobs.parallelStream().collect(Collectors.toMap(Job::getId, x -> x));

        long start = System.currentTimeMillis();
        //并行流计算
        jobs.stream().forEach(x -> {
            doJob(x, jobMap,jobDepIdsMap,featureMap);
        });
        long end = System.currentTimeMillis();
        System.out.println(featureMap);
        System.out.println("cost:" + (end - start) + " ms");
    }



    public static void doJob(Job job, Map<Integer, Job> jobMap, Map<Integer, List<Integer>> jobDepIdsMap, Map<String, Integer> featureMap) {

        List<Integer> dependIds = jobDepIdsMap.get(job.getId());
        int value = job.getId();
        for (Integer dependId : dependIds) {
            Job dependJob = jobMap.get(dependId);
            value += featureMap.get(dependJob.getName());
        }
        featureMap.put(job.getName(), value);
        job.setExecuted(true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
