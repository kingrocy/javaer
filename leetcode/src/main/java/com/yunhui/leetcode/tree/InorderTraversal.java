package com.yunhui.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date : 2021/2/17 4:07 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @desc 二叉树的中序遍历
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        iter(root, res);
        return res;
    }

    //中序遍历 左->根->右
    private void iter(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        iter(root.left, res);
        res.add(root.val);
        iter(root.right, res);
    }


}
