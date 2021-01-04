package com.yunhui.leetcode.tree;

/**
 * @Date : 2021/1/4 9:32 上午
 * @Author : dushaoyun
 */
public class MaxDepth2 {

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return 1+Math.max(left,right);
    }
}
