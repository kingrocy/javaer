package com.yunhui.leetcode.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Date : 2021/2/17 3:30 下午
 * @Author : dushaoyun
 * @link：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @desc：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class LowestCommonAncestor {

    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    /**
     * 使用hash表记录 每个节点的父节点
     * <p>
     * 再求p和q的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        bfs(root);
        Set<TreeNode> parentNodes = new HashSet<>();
        while (p != null) {
            parentNodes.add(p);
            p = parentMap.get(p);
        }
        while (q != null) {
            if (parentNodes.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        return null;
    }

    public void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parentMap.put(root.left, root);
            bfs(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            bfs(root.right);
        }
    }
}
