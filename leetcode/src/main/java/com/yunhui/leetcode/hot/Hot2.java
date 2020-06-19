package com.yunhui.leetcode.hot;

/**
 * @Date : 2020/6/18 2:02 下午
 * @Author : dushaoyun
 */
public class Hot2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode r = new ListNode(0);
        ListNode t=r;
        int forward = 0;
        while (p != null || q != null) {
            int v1 = p == null ? 0 : p.val;
            int v2 = q == null ? 0 : q.val;
            int val = v1 + v2 + forward;
            if (val >= 10) {
                val = val % 10;
                forward = 1;
            } else {
                forward = 0;
            }
            t.next = new ListNode(val);
            t=t.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if(forward>0){
            t.next=new ListNode(forward);
        }
        return r.next;
    }
}
