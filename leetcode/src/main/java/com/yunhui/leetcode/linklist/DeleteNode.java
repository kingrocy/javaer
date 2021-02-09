package com.yunhui.leetcode.linklist;

/**
 * @Date : 2020/6/30 4:32 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/delete-middle-node-lcci/
 */
public class DeleteNode {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        System.out.println(node1);
    }

    /**
     * node为链表中的某个节点 此函数的功能就是删除这个节点
     * 实现思路：把下个节点的值赋值给此节点 然后删除下个节点
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
