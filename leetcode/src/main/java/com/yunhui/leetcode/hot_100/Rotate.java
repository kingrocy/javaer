package com.yunhui.leetcode.hot_100;

/**
 * Created on 2024-01-11
 */
public class Rotate {


    /**
     * 时间复杂度o(n)
     * 空间复杂度o(k)
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        if (k <= 0) {
            return;
        }
        //如果需要轮转的次数大于数字的大小 则进行取余 （因为对于一个长度n的数组，轮转n次后的顺序等于没有轮转）
        if (k > nums.length) {
            k = k % nums.length;
        }
        //1、先把nums.length - k，nums.length的元素保存到一个新的数组
        int[] temp = new int[k];
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            temp[index++] = nums[i];
        }
        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        int k = 3;
        new Rotate().rotate(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
