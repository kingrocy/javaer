package com.yunhui.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date : 2020/11/13 2:49 下午
 * @Author : dushaoyun
 */
public class Generate {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }


    public static List<List<Integer>> generate(int numRows) {
        int k = 1;
        List<List<Integer>> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> nums = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    nums.add(k);
                } else if (j == i) {
                    nums.add(k);
                } else {
                    nums.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(nums);
        }
        return list;
    }
}
