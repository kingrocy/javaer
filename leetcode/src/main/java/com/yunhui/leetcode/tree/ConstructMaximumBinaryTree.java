package com.yunhui.leetcode.tree;

/**
 * @Date : 2021/2/22 4:00 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        //找出元素最大值
        int index = findMaxIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[index]);
        root.left = build(nums, left, index - 1);
        root.right = build(nums, index + 1, right);
        return root;
    }

    public int findMaxIndex(int[] nums, int left, int right) {
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }
}
