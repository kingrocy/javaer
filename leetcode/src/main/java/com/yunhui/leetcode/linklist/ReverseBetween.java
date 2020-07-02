package com.yunhui.leetcode.linklist;

import com.yunhui.leetcode.hot.ListNode;

/**
 * @Date : 2020/7/1 6:11 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseBetween {


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        System.out.println(head);
        ListNode reverseBetween = reverseBetween(head, 1, 6);
        System.out.println(reverseBetween);
    }

    /**
     * 反转链表2  对链表指定范围内的节点进行反转
     * 使用一次扫描解决
     *
     * @param head
     * @param m
     * @param n
     * @return 1 ≤ m ≤ n ≤ 链表长度。
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        //使用一个虚拟头节点 来避免链表从头开始反转导致的空指针异常
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode m_pre = dummyNode;
        ListNode m_ = dummyNode.next;
        int i = 1;
        while (i < m) {
            m_pre = m_pre.next;
            m_ = m_.next;
            i++;
        }
        ListNode revertNode;
        for (int j = 0; j < n - m; j++) {
            revertNode = m_.next;
            m_.next = revertNode.next;
            revertNode.next = m_pre.next;
            m_pre.next = revertNode;
        }
        return dummyNode.next;
    }
}
