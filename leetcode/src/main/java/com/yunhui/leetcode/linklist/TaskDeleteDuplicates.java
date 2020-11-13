package com.yunhui.leetcode.linklist;

/**
 * @Date : 2020/4/10 10:12 上午
 * @Author : dushaoyun
 */
public class TaskDeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode pre = head;
        while (next != null) {
            if (pre.val == next.val) {
                pre.next = next.next;
            } else {
                pre = pre.next;
            }
            next = next.next;
        }
        return head;
    }
}


