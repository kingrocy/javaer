package com.yunhui.base.tree;

import java.util.LinkedList;

/**
 * @Date : 2020/7/8 6:09 下午
 * @Author : dushaoyun
 */
public class bfs {

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(5);

        node.left=node1;
        node.right=node2;

        node1.left=node3;
        node2.right=node4;

        bfs(node);
    }

    public static void bfs(TreeNode treeNode) {
        LinkedList<TreeNode> queue=new LinkedList();
        queue.offer(treeNode);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
    }
}
