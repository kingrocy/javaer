package com.yunhui.leetcode.tree;

/**
 * @Date : 2021/2/17 4:35 下午
 * @Author : dushaoyun
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
