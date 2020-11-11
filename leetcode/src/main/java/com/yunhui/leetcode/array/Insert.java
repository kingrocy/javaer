package com.yunhui.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date : 2020/11/4 5:54 下午
 * @Author : dushaoyun
 */
public class Insert {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null) {
            return intervals;
        }
        int [] newIntervalCopy=newInterval;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(newIntervalCopy==null){
                list.add(interval);
                continue;
            }
            //判断两个数组有没有交集
            if (newIntervalCopy[1] < interval[0]) {
                list.add(newIntervalCopy);
                list.add(interval);
                newIntervalCopy=null;
            } else if (interval[1] < newIntervalCopy[0]) {
                list.add(interval);
            } else {
                //有交集
                int[] temp = new int[2];
                temp[0] = Math.min(interval[0], newIntervalCopy[0]);
                temp[1] = Math.max(interval[1], newIntervalCopy[1]);
                newIntervalCopy = temp;
            }
        }
        if(newIntervalCopy!=null){
            list.add(newIntervalCopy);
        }
        return list.toArray(new int[list.size()][]);
    }
}
