package com.yunhui.leetcode.hot_100;

/**
 * Created on 2024-02-29
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return processor(nums, 0, nums.length - 1);
    }


    private TreeNode processor(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int mid = (j + i) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = processor(nums, i, mid - 1);
        root.right = processor(nums, mid + 1, j);
        return root;
    }
}
