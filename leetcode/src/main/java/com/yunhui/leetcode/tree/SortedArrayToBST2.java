package com.yunhui.leetcode.tree;

/**
 * @Date : 2021/1/4 10:26 上午
 * @Author : dushaoyun
 */
public class SortedArrayToBST2 {


    public TreeNode sortedArrayToBST(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    public TreeNode process(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode tree = new TreeNode(nums[mid]);
        tree.left = process(nums, left, mid - 1);
        tree.right = process(nums, mid + 1, right);
        return tree;
    }

}
