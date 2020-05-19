package com.yunhui.leetcode.easy;

/**
 * @Date : 2020/4/28 10:37 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/symmetric-tree/
 * @desc 判断一棵二叉树是否是对称的
 */
public class TaskIsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        return (t1.val==t2.val)&&isMirror(t1.left, t2.right)&&isMirror(t1.right, t2.left);
    }

}
