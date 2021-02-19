package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/2/17 1:31 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @desc 两两交换链表中的节点
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode p = head;
        while (p != null && p.next != null) {
            ListNode q = p.next;
            ListNode next = q.next;
            pre.next = q;
            q.next = p;
            p.next = next;
            pre = p;
            p = next;
        }
        return res.next;
    }
}
