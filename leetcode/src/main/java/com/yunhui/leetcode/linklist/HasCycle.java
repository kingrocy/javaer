package com.yunhui.leetcode.linklist;

/**
 * @Date : 2020/7/1 1:35 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/linked-list-cycle/submissions/
 */
public class HasCycle {

    /**
     * 判断链表是否有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        //循环结束条件是 快指针是否到达链表的尾部
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //如果链表有环 那么快慢指针一定会相交
            if (slow == fast) {
                return true;
            }
        }
        //循环退出的话 代表没有环
        return false;
    }
}
