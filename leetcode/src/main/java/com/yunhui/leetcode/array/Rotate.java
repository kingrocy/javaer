package com.yunhui.leetcode.array;

import java.util.Arrays;

/**
 * @Date : 2021/2/7 1:38 下午
 * @Author : dushaoyun
 */
public class Rotate {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        Rotate rotate = new Rotate();
        rotate.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }


    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return;
        }
        if(k==0||k%n==0){
            return;
        }
        k=k%n;
        revert(nums, 0, n - 1);
        revert(nums, 0, k - 1);
        revert(nums, k, n - 1);
    }

    public void revert(int[] nums, int left, int right) {
        int temp = nums[right];
        while (left < right) {
            nums[right] = nums[left];
            nums[left] = temp;
            right--;
            left++;
            temp = nums[right];
        }
    }

}
