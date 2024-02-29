package com.yunhui.leetcode.linklist;

/**
 * Created on 2024-02-26
 * https://leetcode.cn/problems/partition-list/
 */
public class Partition2 {

    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {

            return head;
        }


        //小于x
        ListNode dummy1 = new ListNode(-1);
        ListNode p1 = dummy1;
        //大于x
        ListNode dummy2 = new ListNode(-1);
        ListNode p2 = dummy2;

        ListNode p = head;

        while (p != null) {

            if (p.val < x) {

                p1.next = p;
                p1 = p1.next;

            } else {
                p2.next = p;
                p2 = p2.next;
            }

            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }

        p1.next = dummy2.next;
        dummy2.next = null;
        return dummy1.next;
    }
}
