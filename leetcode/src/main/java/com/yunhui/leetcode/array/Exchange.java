package com.yunhui.leetcode.array;

import java.util.Arrays;

/**
 * @Date : 2021/2/13 6:46 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @desc: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class Exchange {

    public static void main(String[] args) {
        Exchange exchange = new Exchange();
        int[] ints = exchange.exchange(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
    }

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //找出偶数
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            //找出奇数
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
        return nums;
    }
}
