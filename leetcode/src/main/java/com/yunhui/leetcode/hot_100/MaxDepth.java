package com.yunhui.leetcode.hot_100;

/**
 * Created on 2024-02-29
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
        }
    }
}
