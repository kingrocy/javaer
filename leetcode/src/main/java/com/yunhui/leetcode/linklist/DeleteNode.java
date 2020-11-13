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

        deleteNode2(node1);
        System.out.println(node1);

        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node3.next = node4;
        node4.next = node5;
        System.out.println(node1);


        deleteNode2(node1);
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

    /**
     * 给定链表node，当node的节点数为单数时，返回中间的节点。如果node的节点数为复数，返回中间偏左的节点。
     *
     * @param node
     */
    public static void deleteNode2(ListNode node) {
        ListNode head = new ListNode(0);
        head.next = node;
        ListNode fast = head;
        ListNode low = head;
        ListNode pre = null;
        while (low != null && low.next != null) {
            pre = fast;
            fast = fast.next;
            low = low.next.next;
        }
        //fast为链表中间的节点  删除
        pre.next = fast.next;
    }
}
