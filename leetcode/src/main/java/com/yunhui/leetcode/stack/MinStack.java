package com.yunhui.leetcode.stack;

/**
 * @Date : 2020/12/28 5:11 下午
 * @Author : dushaoyun
 */
public class MinStack {

    private ListNode stack;


    public MinStack() {
    }

    public void push(int x) {
        ListNode node = new ListNode(x);
        if (stack == null) {
            stack = node;
        } else {
            node.next = stack;
            stack = node;
        }
    }

    public void pop() {
        if (stack != null) {
            stack = stack.next;
        }
    }

    public int top() {
        return stack.val;
    }

    public int getMin() {
        int min = stack.val;
        ListNode cur = stack.next;
        while (cur != null) {
            if(cur.val<min){
                min=cur.val;
            }
            cur=cur.next;
        }
        return min;
    }

    public static class ListNode {

        private int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
