package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/2/13 12:07 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists2 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null) {
            int m = p.val;
            int n = q.val;
            if (m < n) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
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
