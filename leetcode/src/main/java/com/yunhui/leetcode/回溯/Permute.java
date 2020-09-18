package com.yunhui.leetcode.回溯;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

/**
 * @Date : 2020/9/18 3:22 下午
 * @Author : dushaoyun
 * @desc 输入一组不重复的数字，返回它们的全排列
 */
public class Permute {

    static List<List<Integer>> res = new LinkedList<>();


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        System.out.println(JSON.toJSONString(res));
    }

    /**
     * 路径：记录在 track 中
     * 选择列表：nums 中不存在于 track 的那些元素
     * 结束条件：nums 中的元素全都在 track 中出现
     *
     * @param nums
     * @param track
     */
    public static void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }
}
