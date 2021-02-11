package com.yunhui.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Date : 2021/2/11 12:54 上午
 * @Author : dushaoyun
 * @desc :
 * 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum2 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return res;
        }
        //先对数组进行排序 因为只有数组有序才方便进行去重过滤
        Arrays.sort(nums);
        //第一层遍历 固定i 之后的j、k采用滑动窗户
        for (int i = 0; i < nums.length; i++) {
            //此处不能去除=0的 因为输入的数组 可能为[0,0,0]
            if (nums[i] > 0) {
                break;
            }
            //如果数组的上一个元素和当前元素相等 需要跳过当前元素避免重复
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    //在缩短j,k区间时 先进行下去重操作
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (k > j && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    //缩短j，k区间
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
