package com.yunhui.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Date : 2021/2/9 9:33 下午
 * @Author : dushaoyun
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 1;
        for (int num : nums) {
            /**
             * 如果已知有一个 x, x+1, x+2, ⋯,x+y 的连续序列，
             * 而我们却重新从 x+1，x+2 或者是 x+y 处开始尝试匹配，
             * 那么得到的结果肯定不会优于枚举 xx 为起点的答案，
             * 因此我们在外层循环的时候碰到这种情况跳过即可。
             *
             * 那么怎么判断是否跳过呢？由于我们要枚举的数 x
             * 一定是在数组中不存在前驱数 x-1 的，
             * 不然按照上面的分析我们会从 x-1 开始尝试匹配，
             * 因此我们每次在哈希表中检查是否存在 x-1即能判断是否需要跳过了。
             */
            if (!set.contains(num - 1)) {
                int cnt = 1;
                while (set.contains(++num)) {
                    cnt++;
                    max = Math.max(max, cnt);
                }
            }
        }
        return max;
    }
}
