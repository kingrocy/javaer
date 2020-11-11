package com.yunhui.leetcode.tree;

import com.yunhui.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Date : 2020/4/28 11:27 上午
 * @Author : dushaoyun
 * @Desc 傻瓜式解法   二叉树的层次遍历
 * @link https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodes.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    treeNodes.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodes.offer(treeNode.right);
                }
            }
            resultList.add(0, list);
        }
        return resultList;
    }
}
