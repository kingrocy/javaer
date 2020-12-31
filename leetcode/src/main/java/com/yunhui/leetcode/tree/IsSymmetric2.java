package com.yunhui.leetcode.tree;

/**
 * @Date : 2020/12/31 5:59 下午
 * @Author : dushaoyun
 */
public class IsSymmetric2 {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
