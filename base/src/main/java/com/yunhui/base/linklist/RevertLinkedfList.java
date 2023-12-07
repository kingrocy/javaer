package com.yunhui.base.linklist;

/**
 * @Date : 2020/6/28 5:10 下午
 * @Author : dushaoyun
 */
public class RevertLinkedfList {

    public static void main(String[] args) {
        Node node = new Node(5, new Node(4, new Node(3, null)));
        System.out.println(node);
        Node revert = revert(node);
        System.out.println(revert);
    }

    //头插法
    public static Node revert(Node node) {
        Node res = null;
        Node next;
        Node p = node;
        while (p != null) {
            next = p.next;
            p.next = res;
            res = p;
            p = next;
        }
        return res;
    }

    public static Node revert2(Node node) {
        Node head = node;
        if (node == null || node.next == null) {
            return node;
        }
        Node cur = revert2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }


}
