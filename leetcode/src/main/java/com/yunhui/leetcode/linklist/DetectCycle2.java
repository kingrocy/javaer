package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/2/13 8:15 下午
 * @Author : dushaoyun
 * @link：https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class DetectCycle2 {

    /**
     * 环形链表||
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow == fast) {
            ListNode p = head;
            while (p != slow) {
                p = p.next;
                slow = slow.next;
            }
            return p;
        } else {
            return null;
        }
    }
}
