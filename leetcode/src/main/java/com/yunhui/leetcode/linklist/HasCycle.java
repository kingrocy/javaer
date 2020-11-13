package com.yunhui.leetcode.linklist;

/**
 * @Date : 2020/7/1 1:35 下午
 * @Author : dushaoyun
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head.next;
        while (fast != null && slow != null && slow.next != null) {
            if (fast == slow) {
                return true;

            }
            fast = fast.next;
            slow = slow.next.next;
        }
        return false;
    }
}
