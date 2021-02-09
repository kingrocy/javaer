package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/2/9 8:58 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseBetween3 {

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 1 ≤ m ≤ n ≤ 链表长度
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null || m == n) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        int i = 0;
        ListNode p = newHead;
        ListNode pre = null;
        ListNode preNext = null;
        ListNode cur = null;
        ListNode next = null;
        while (p != null && i <= n) {
            next = p.next;
            if (i == m - 1) {
                pre = p;
            } else if (i == m) {
                preNext = p;
                cur = p;
            } else if (i > m && i <= n) {
                cur.next = next;
                p.next = preNext;
                pre.next = p;
                preNext = p;
            }
            p = next;
            i++;
        }
        return newHead.next;
    }
}
