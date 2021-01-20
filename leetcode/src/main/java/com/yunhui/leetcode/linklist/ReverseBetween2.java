package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/1/20 10:08 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseBetween2 {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        reverseBetween(listNode1, 2, 4);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 0;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode first = null;
        ListNode pre = null;
        ListNode preNext = null;
        ListNode p = res;
        ListNode next;
        while (p != null && i <= n) {
            next = p.next;
            if (i == m - 1) {
                pre = p;
            } else if (i == m) {
                first = p;
                preNext = p;
            } else if (i > m && i <= n) {
                first.next = p.next;
                pre.next = p;
                p.next = preNext;
                preNext = p;
            }
            p = next;
            i++;
        }
        return res.next;
    }
}
