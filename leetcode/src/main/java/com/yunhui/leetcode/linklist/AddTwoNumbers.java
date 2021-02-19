package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/2/16 10:55 下午
 * @Author : dushaoyun
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        ListNode p = l1;
        ListNode q = l2;
        int beyond = 0;
        while (p != null || q != null) {
            int m = p == null ? 0 : p.val;
            int n = q == null ? 0 : q.val;
            int val = m + n + beyond;
            if (val >= 10) {
                beyond = val / 10;
            } else {
                beyond = 0;
            }
            ListNode node = new ListNode(val % 10);
            cur.next = node;
            cur = cur.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (beyond > 0) {
            ListNode node = new ListNode(beyond);
            cur.next = node;
        }
        return res.next;
    }
}
