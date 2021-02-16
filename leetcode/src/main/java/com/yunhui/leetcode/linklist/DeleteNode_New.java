package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/2/13 7:14 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @desc 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 */
public class DeleteNode_New {


    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode p = res;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return res.next;
    }
}
