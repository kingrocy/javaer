package com.yunhui.leetcode.linklist;

import com.yunhui.leetcode.hot.ListNode;

/**
 * @Date : 2020/7/1 10:35 上午
 * @Author : dushaoyun
 */
public class Partition {

    public static void main(String[] args) {
        ListNode partition = partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3);
        System.out.println(partition);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode p = before;
        ListNode q = after;
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        q.next = null;
        p.next = after.next;
        return before.next;
    }
}
