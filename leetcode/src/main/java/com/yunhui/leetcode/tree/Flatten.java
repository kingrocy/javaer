package com.yunhui.leetcode.tree;

/**
 * @Date : 2021/2/22 3:07 下午
 * @Author : dushaoyun
 */
public class Flatten {

    public void flatten(TreeNode root) {
        TreeNode res = new TreeNode();
        preorder(root, res);
        root = res.right;
    }

    public void preorder(TreeNode root, TreeNode res) {
        if(root==null){
            return;
        }
        res.left=null;
        res.right=root;
        res=res.right;
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
