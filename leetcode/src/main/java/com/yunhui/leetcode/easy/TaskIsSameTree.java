package com.yunhui.leetcode.easy;

/**
 * @Date : 2020/4/26 2:49 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/same-tree/
 */
public class TaskIsSameTree {

    /**
     * 判断两棵树是否相同
     * 遍历一下看看是否一样就好了
     * <p>
     * 补充：树的三种遍历方式
     * <p>
     * 1、先序遍历   根节点->左子树->右子树
     * 2、中序遍历   左子树->根节点->右子树
     * 3、后续遍历   左子树->右子树->根节点
     */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (q == null || p == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
