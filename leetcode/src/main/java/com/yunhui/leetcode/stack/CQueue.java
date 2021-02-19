package com.yunhui.leetcode.stack;

import java.util.Stack;

/**
 * @Date : 2021/2/16 11:38 下午
 * @Author : dushaoyun
 */
public class CQueue {


    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;
            } else {
                while (!stack1.isEmpty()) {
                    int val = stack1.pop();
                    stack2.push(val);
                }
            }
        }
        return stack2.pop();
    }
}
