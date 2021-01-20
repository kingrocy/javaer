package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/1/20 10:00 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList3 {

    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode p = head;
        ListNode next;
        while (p != null) {
            next = p.next;
            p.next = res;
            res = p;
            p = next;
        }
        return p;
    }
}
