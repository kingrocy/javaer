package com.yunhui.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date : 2020/11/2 10:02 上午
 * @Author : dushaoyun
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        dfs(root, new StringBuilder(), result);
        return result;
    }


    public void dfs(TreeNode root, StringBuilder path, List<String> result) {
        if (root == null) {
            return;
        }
        path.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(path.toString());
        }else {
            path.append("->");
            dfs(root.left,new StringBuilder(path),result);
            dfs(root.right,new StringBuilder(path),result);
        }
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

