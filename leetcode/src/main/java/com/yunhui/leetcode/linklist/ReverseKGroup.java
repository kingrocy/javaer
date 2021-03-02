package com.yunhui.leetcode.linklist;

import java.util.Stack;

/**
 * @Date : 2020/7/6 5:11 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/
 */
public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        //使用一个栈来辅助操作
        Stack<ListNode> stack = new Stack<>();
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode p = res;
        ListNode q = p.next;
        while (q != null) {
            for (int i = 0; i < k && q != null; i++) {
                stack.push(q);
                q = q.next;
            }
            if (stack.size() != k) {
                return res.next;
            }
            p.next = q;
            while (!stack.isEmpty()) {
                ListNode next = p.next;
                ListNode node = stack.pop();
                p.next = node;
                node.next = next;
                p=node;
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        reverseKGroup(listNode1, 3);
    }


}
