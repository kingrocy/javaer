package com.yunhui.leetcode.linklist;

/**
 * @Date : 2020/7/2 4:33 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class InsertionSortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        System.out.println(head);
        ListNode reverseBetween = insertionSortList(head);
        System.out.println(reverseBetween);
    }

    /**
     * 对链表进行插入排序
     *
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode p = head.next;
        head.next = null;

        while (p != null) {
            ListNode next = p.next;
            ListNode pre = dummyNode;
            ListNode cur = dummyNode.next;
            while (cur != null) {
                if (p.val <= cur.val) {
                    p.next = cur;
                    pre.next = p;
                    break;
                } else {
                    if (cur.next == null) {
                        p.next = null;
                        cur.next = p;
                        break;
                    } else {
                        cur = cur.next;
                        pre = pre.next;
                    }
                }
            }
            p = next;
        }
        return dummyNode.next;
    }
}
