package com.yunhui.leetcode.tree;

/**
 * @Date : 2021/3/10 9:46 上午
 * @Author : dushaoyun
 */
public class kthLargest {

    int res;
    int k;

    //右根左遍历
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        traverse(root);
        return res;
    }


    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        if (k == 0) {
            return;
        }
        k--;
        if (k == 0) {
            res = root.val;
            return;
        }
        traverse(root.left);
    }
}
