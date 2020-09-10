package com.yunhui.leetcode.array;

/**
 * @Date : 2020/8/10 5:40 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum2 {

    //暴力
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        L1:
        for (int i = 0; i < numbers.length - 1; i++) {
            L2:
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] > target) {
                    break L2;
                } else if (numbers[i] + numbers[j] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    break L1;
                }
            }
        }
        return res;
    }


    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            } else {
                l++;
            }
        }
        return res;
    }
}
