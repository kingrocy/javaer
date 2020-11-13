package com.yunhui.leetcode.linklist;

/**
 * @Date : 2020/7/2 4:03 下午
 * @Author : dushaoyun
 * 反转链表  同RevertLinkedfList.java
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next;
        ListNode p = head;
        while (p.next != null) {
            next = p.next;
            p.next = next.next;
            next.next = head;
            head = next;
        }
        return head;
    }


    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = null;
        ListNode p = head;
        ListNode next;
        while (p != null) {
            //遍历老链表 每个节点头插法插入到新链表
            next=p.next;
            p.next=res;
            res=p;
            p=next;
        }
        return res;
    }
}
