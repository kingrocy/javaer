package com.yunhui.leetcode.tree;

/**
 * @Date : 2020/4/28 10:54 上午
 * @Author : dushaoyun
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
