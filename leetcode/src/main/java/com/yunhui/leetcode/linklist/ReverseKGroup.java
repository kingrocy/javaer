package com.yunhui.leetcode.linklist;

import com.yunhui.leetcode.hot.ListNode;

/**
 * @Date : 2020/7/6 5:11 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        //此时a已经变成了链表的尾节点
        ListNode newHead = reverse(a, b);
        //本次翻转后的链表的尾节点连接上下一个待翻转链表的头节点，递归实现
        a.next = reverseKGroup(b, k);
        return newHead;
    }


    public ListNode reverse(ListNode head, ListNode end) {
        ListNode pre = null, cur = head, next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //返回反转后的头节点
        return pre;
    }
}
