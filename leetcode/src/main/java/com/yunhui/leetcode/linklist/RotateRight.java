package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/2/7 2:08 下午
 * @Author : dushaoyun
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        if (k == 0) {
            return head;
        }
        ListNode p = head;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        //找到了链表的长度
        if (k % n == 0) {
            return head;
        }
        k = k % n;
        ListNode m = head;
        ListNode tail = null;
        for (int i = 0; i < n - k; i++) {
            if (i == n - k - 1) {
                tail = m;
            }
            m = m.next;
        }
        //断开原链表
        tail.next = null;
        ListNode q = m;
        while (q.next != null) {
            q = q.next;
        }
        q.next = head;
        return m;
    }
}
