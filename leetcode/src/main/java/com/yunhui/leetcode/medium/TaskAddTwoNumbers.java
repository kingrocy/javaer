package com.yunhui.leetcode.medium;

/**
 * @Date : 2019-09-11 16:55
 * @Desc :
 */
public class TaskAddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode q = l1;
        ListNode p = l2;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int num = 0;
        while (q != null || p != null) {
            int x = (q != null) ? q.val : 0;
            int y = (p != null) ? p.val : 0;
            int sum = num + x + y;
            num = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (q != null) {
                q = q.next;
            }
            if (p != null) {
                p = p.next;
            }
        }
        if (num > 0) {
            cur.next = new ListNode(num);
        }
        return result.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
