package com.yunhui.leetcode.hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2024-02-29
 * 请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 中序遍历，取k-1个值
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        travel(root, list);
        return list.get(k - 1);
    }

    private void travel(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        travel(root.left, list);
        list.add(root.val);
        travel(root.right, list);
    }
}
