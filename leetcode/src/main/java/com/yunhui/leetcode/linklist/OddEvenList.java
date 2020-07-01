package com.yunhui.leetcode.linklist;

import com.yunhui.leetcode.hot.ListNode;

/**
 * @Date : 2020/7/1 9:18 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class OddEvenList {

    /**
     * 奇偶链表
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        ListNode qc = q;
        while (qc != null && qc.next != null) {
            p.next = qc.next;
            p = p.next;
            qc.next = p.next;
            qc = qc.next;
        }
        p.next = q;
        return head;
    }
}
