package com.yunhui.leetcode.tree;

/**
 * @Date : 2021/2/22 3:15 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class Connect {

    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        connectNode(root.left,root.right);
        return root;
    }

    public void connectNode(Node left, Node right) {
        if (left == null) {
            return;
        }
        left.next = right;
        if (right == null) {
            return;
        }
        connectNode(left.left,left.right);
        connectNode(left.left,right.left);
        connectNode(right.left,right.right);
    }
}
