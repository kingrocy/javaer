package com.yunhui.leetcode.linklist;

/**
 * Created on 2023-12-07
 * @link：https://leetcode.cn/problems/add-two-numbers/
 */
public class AddTwoNumbers2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p = l1;
        ListNode q = l2;

        ListNode res = new ListNode(0);

        ListNode t = res;

        int m = 0;

        while (p != null || q != null) {

            int sum = m;

            if (p != null) {
                sum += p.val;
                p = p.next;
            }

            if (q != null) {
                sum += q.val;
                q = q.next;
            }
            m = sum / 10;
            if (sum >= 10) {
                sum = sum % 10;
            }
            ListNode node = new ListNode(sum);
            t.next = node;
            t = t.next;
        }

        if (m > 0) {
            ListNode node = new ListNode(m);
            t.next = node;
        }

        return res.next;
    }

}
