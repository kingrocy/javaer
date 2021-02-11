package com.yunhui.leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Date : 2021/2/11 11:59 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/comments/265774
 */
public class MaxDepth3 {

    /**
     * 求树的最大深度 使用非递归算法
     * <p>
     * 树的层序遍历 一般都是使用队列来做的
     *
     * 这边通过层序遍历的方法来做
     *
     * 在层序遍历的时候 为每一次的节点 加一个高度
     *
     * 每进入新的一层 则+1

     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 1;
        //使用一个map 来记录 每个节点 的高度
        Map<TreeNode, Integer> nodeMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList();
        nodeMap.put(root, 1);
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                Integer depth = nodeMap.get(treeNode);
                //需要取最大值
                max = Math.max(max, depth);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                    //当前节点的左子树 不为空 则进入下一层 子节点深度+1
                    nodeMap.put(treeNode.left, depth + 1);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                    //同理
                    nodeMap.put(treeNode.right, depth + 1);
                }
            }
        }
        return max;
    }
}
