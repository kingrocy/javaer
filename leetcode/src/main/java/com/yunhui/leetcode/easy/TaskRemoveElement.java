package com.yunhui.leetcode.easy;

import java.util.Arrays;

/**
 * @Date : 2020/3/31 2:14 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/remove-element/
 * @DESc 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 */
public class TaskRemoveElement {

    /**
     * 双指针解法
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int removeElement2(int[] nums, int val) {
        int i=0;
        int n=nums.length;
        while(i<n){
            if(nums[i]==val){
                nums[i]=nums[n-1];
                n--;
            }else{
                //此处注意： 当nums[i]==val 时 i不可++  因为需要检查从尾部交换过来的数是不是要被替换的数
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{0,1,2,3,4};
        int i = removeElement1(nums, 2);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));

    }
}
