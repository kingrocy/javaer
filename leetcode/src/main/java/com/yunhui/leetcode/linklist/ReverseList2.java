package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/1/7 3:27 下午
 * @Author : dushaoyun
 */
public class ReverseList2 {

    /**
     * 头插法永远的神
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = null;
        ListNode next;
        ListNode p = head;
        while (p != null) {
            next = p.next;
            p.next = res;
            res = p;
            p = next;
        }
        return res;
    }

}
