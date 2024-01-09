package com.yunhui.leetcode.linklist;

/**
 * Created on 2024-01-08
 */
public class ReverseBetween4 {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        //[1,2,3,4,5]   2,4

        if (head == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        ListNode start = pre.next;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
            start = start.next;
        }
        ListNode next;
        for (int j = 0; j < n - m; j++) {
            next = start.next;
            start.next = next.next;
            next.next =  pre.next;
            pre.next = next;
        }

        return dummyNode.next;

    }

}
