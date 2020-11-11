package com.yunhui.leetcode.tree;

/**
 * @Date : 2020/11/11 10:57 上午
 * @Author : dushaoyun
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;


    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}