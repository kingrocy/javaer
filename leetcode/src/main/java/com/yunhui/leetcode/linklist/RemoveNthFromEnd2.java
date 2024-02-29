package com.yunhui.leetcode.linklist;

/**
 https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * Created on 2024-02-26
 */
public class RemoveNthFromEnd2 {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //主要 这里要找删除的元素的 上一个节点 (因为是移除倒数的某个节点，增加一个虚拟头结点没有影响)
        ListNode target = findFromEnd(dummy, n + 1);
        if (target == null) {
            return head;
        }
        target.next = target.next.next;
        return dummy.next;
    }

    private ListNode findFromEnd(ListNode head, int k) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        ListNode q = head;
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
