package com.yunhui.leetcode.array;

import java.util.Arrays;

/**
 * @Date : 2020/3/30 5:04 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @desc 删除排序数组中的重复项
 */
public class TaskRemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==1){
            return nums.length;
        }
        int i=0;
        int j=1;
        while (j<nums.length){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
            j++;
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,1,2,2,3};
        int i = removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }
}
