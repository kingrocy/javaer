package com.yunhui.leetcode.tree;

/**
 * @Date : 2021/2/17 2:27 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/subtree-of-another-tree/
 * @desc 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 */
public class IsSubtree {

    /**
     * 判断一棵树 是否是另一颗树的子树
     *
     * 判断三步：
     *
     * 1、判断这两课树是否相等
     *
     * 2、递归判断 树的左右子树 是否包含目标数
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null){
            return false;
        }
        // 短路运算符，有一个为真，返回真
        return isSameTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean isSameTree(TreeNode s,TreeNode t){
        // 同时为空 说明树一起到底，两树相同
        if (s==null && t == null){
            return true;
        }
        //判断是不是一个为空 一个不为空
        if (s == null || t == null){
            return false;
        }
        // 两个都不为空 开始比较树是否相等
        if (s.val != t.val){
            return false;
        }
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }
}
