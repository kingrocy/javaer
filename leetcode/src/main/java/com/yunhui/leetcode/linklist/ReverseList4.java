package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/2/9 7:07 下午
 * @Author : dushaoyun
 */
public class ReverseList4 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = null;
        ListNode p = head;
        ListNode next = null;
        while (p != null) {
            next = p.next;
            p.next = res;
            res = p;
            p = next;
        }
        return res;
    }
}
