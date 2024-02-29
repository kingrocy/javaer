package com.yunhui.leetcode.hot_100;

/**
 * Created on 2024-02-29
 */
public class DiameterOfBinaryTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }


    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth1 = depth(root.left);
        int depth2 = depth(root.right);
        max = Math.max(depth1 + depth2, max);
        return Math.max(depth1, depth2) + 1;
    }
}
