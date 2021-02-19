package com.yunhui.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2021/2/16 5:04 下午
 * @Author : dushaoyun
 */
public class BuildTree {

    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildMyTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    public TreeNode buildMyTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        //递归终止条件 即 传入的区间参数 不能构成一个真正的区间 此时需要退出
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        //获取 根节点在中序遍历中的索引
        int pIndex = indexMap.get(rootVal);
        root.left = buildMyTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, inorder, inLeft, pIndex - 1);
        root.right = buildMyTree(preorder, pIndex - inLeft + preLeft + 1, preRight, inorder, pIndex + 1, inRight);
        return root;
    }
}
