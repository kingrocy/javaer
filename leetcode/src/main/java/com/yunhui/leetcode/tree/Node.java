package com.yunhui.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2021/2/22 3:16 下午
 * @Author : dushaoyun
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

}