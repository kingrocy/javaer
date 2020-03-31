package com.yunhui.paraller.work;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @Date : 2019-12-05 17:55
 * @Author :
 * @CopyRight :
 * @Desc :
 */
public class ParallerExecute {


    public static void main(String[] args) {

        Job job1 = new Job(1, "A", Lists.newArrayList(2, 3), false, false);
        Job job2 = new Job(2, "B", Lists.newArrayList(4), true, false);
        Job job3 = new Job(3, "C", Lists.newArrayList(5), true, false);
        Job job4 = new Job(4, "D", Lists.newArrayList(), true, false);
        Job job5 = new Job(5, "E", Lists.newArrayList(), true, false);
        Job job6 = new Job(6, "F", Lists.newArrayList(), false, false);

        List<Job> jobs = Lists.newArrayList(job1, job2, job3, job4, job5, job6);

        Map<String,Integer> featureMap= Maps.newConcurrentMap();

        //job depend mapping
        Map<Integer, List<Integer>> jobDepIdsMap = jobs.parallelStream().collect(Collectors.toMap(Job::getId, Job::getDependIds));

        //job id mapping
        Map<Integer, Job> jobMap = jobs.parallelStream().collect(Collectors.toMap(Job::getId, x -> x));

        //头部节点
        List<Job> headJobs = jobs.parallelStream().filter(x -> !x.getDepended()).collect(Collectors.toList());

        long start=System.currentTimeMillis();
        //并行流计算
        headJobs.parallelStream().forEach(x -> {
            dfs(x,jobMap,jobDepIdsMap, featureMap);
        });
        long end=System.currentTimeMillis();
        System.out.println(featureMap);
        System.out.println("cost:"+(end-start)+" ms");

    }

    public static void dfs(Job job, Map<Integer, Job> jobMap,Map<Integer, List<Integer>> jobDepIdsMap,Map<String,Integer> featureMap) {
        List<Integer> dependIds = job.getDependIds();
        if (CollectionUtils.isNotEmpty(dependIds)) {
            for (Integer dependId : dependIds) {
                Job njob = jobMap.get(dependId);
                dfs(njob, jobMap,jobDepIdsMap,featureMap);
            }
        }
        //执行job
        if(job.getExecuted()==false){
            doJob(job, jobMap, jobDepIdsMap, featureMap);
        }
    }


    public static void doJob(Job job,Map<Integer, Job> jobMap,Map<Integer, List<Integer>> jobDepIdsMap,Map<String,Integer> featureMap){
        Lock lock=new ReentrantLock();
        try {
            lock.lock();
            List<Integer> dependIds = jobDepIdsMap.get(job.getId());
            int value=job.getId();
            for (Integer dependId : dependIds) {
                Job dependJob = jobMap.get(dependId);
                value+=featureMap.get(dependJob.getName());
            }
            featureMap.put(job.getName(), value);
            job.setExecuted(true);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
