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
        if (stack == null) {
            stack = new ListNode(x, x);
        } else {
            ListNode node = new ListNode(x, Math.min(x, stack.min), stack);
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
        return stack.min;
    }

    public static class ListNode {

        private int val;

        private int min;

        private ListNode next;

        public ListNode(int val, int min) {
            this.val = val;
            this.min = min;
        }

        public ListNode(int val, int min, ListNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

}
