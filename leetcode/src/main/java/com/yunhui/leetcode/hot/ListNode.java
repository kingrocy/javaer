package com.yunhui.leetcode.hot;

/**
 * @Date : 2020/6/18 2:03 下午
 * @Author : dushaoyun
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode p = next;
        while (p != null) {
            sb.append("->");
            sb.append(p.val);
            p = p.next;
        }
        return sb.toString();
    }
}