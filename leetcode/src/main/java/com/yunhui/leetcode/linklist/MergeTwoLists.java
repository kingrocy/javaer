package com.yunhui.leetcode.linklist;

/**
 * @Date : 2020/12/29 5:55 下午
 * @Author : dushaoyun
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        ListNode p = l1, q = l2;
        while (p != null && q != null) {
            if (p.val >= q.val) {
                cur.next = q;
                q = q.next;
            } else {
                cur.next = p;
                p = p.next;
            }
            cur = cur.next;
        }
        if (p != null) {
            cur.next = p;
        }
        if (q != null) {
            cur.next = q;
        }
        return res.next;
    }
}
