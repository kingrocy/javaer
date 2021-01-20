package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/1/20 9:21 上午
 * @Author : dushaoyun
 * @desc https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveElements {

    /**
     * 链表头部加个哨兵就好了
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode p = head;
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
            } else {
                pre = p;
            }
            p = p.next;
        }
        return res.next;
    }
}
