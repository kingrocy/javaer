package com.yunhui.leetcode.linklist;

/**
 * @Date : 2020/11/11 11:02 上午
 * @Author : dushaoyun
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x,ListNode next) {
        val = x;
        this.next=next;
    }
}