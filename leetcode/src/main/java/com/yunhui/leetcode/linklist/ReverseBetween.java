package com.yunhui.leetcode.linklist;

/**
 * @Date : 2020/7/1 6:11 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseBetween {


    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        System.out.println(head);
        ListNode reverseBetween = reverseBetween(head, 1, 1);
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
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = dummyNode.next;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        ListNode q;
        for (int j = 0; j < n - m; j++) {
            q = cur.next;
            cur.next = q.next;
            q.next = pre.next;
            pre.next = q;
        }
        return dummyNode.next;
    }
}
