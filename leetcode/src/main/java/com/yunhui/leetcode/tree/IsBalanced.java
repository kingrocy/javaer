package com.yunhui.leetcode.tree;

/**
 * @Date : 2020/11/11 10:56 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/balanced-binary-tree/
 * @Desc 平衡二叉树
 */
public class IsBalanced {


    public boolean isBalanced(TreeNode root) {
        if (root != null) {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
        return true;
    }


    public int height(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            return Math.max(height(treeNode.left), height(treeNode.right)) + 1;
        }
    }
}
