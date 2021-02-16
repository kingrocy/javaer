package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/2/13 8:01 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class HasCycle2 {


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
