package com.yunhui.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created on 2024-02-28
 */
public class LevelOrder2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        result.add(Collections.singletonList(root.val));
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    list.add(node.left.val);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    list.add(node.right.val);
                    queue.offer(node.right);
                }
            }
            if (list.size() > 0) {
                result.add(list);
            }
        }
        return result;
    }
}
