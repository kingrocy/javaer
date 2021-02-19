package com.yunhui.leetcode.tree;

/**
 * @Date : 2021/2/16 3:48 下午
 * @Author : dushaoyun
 */
public class DiameterOfBinaryTree {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (left + right > max) {
            max = left + right;
        }
        return Math.max(left, right) + 1;
    }
}
