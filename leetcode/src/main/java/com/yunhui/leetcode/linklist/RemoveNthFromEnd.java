package com.yunhui.leetcode.linklist;

import com.yunhui.leetcode.hot.ListNode;

/**
 * @Date : 2020/6/30 4:47 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * <p>
     * 1、笨方法：遍历2次链表
     * 2、聪明方法 需要用一个额外空间Map<Integer,ListNode>记录 每个节点对应的位置  这样的话一次遍历就可以知道了
     * 3、更聪明方法：快慢指针，快指针先走n步。然后快慢一起走，当块指针走到头，慢指针的位置就是倒数第n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode slaver = new ListNode(0);
        slaver.next = head;
        ListNode fast = slaver;
        ListNode slow = slaver;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return slaver.next;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode p = head;
        while (p != null) {
            size++;
            p = p.next;
        }
        int index = size - n;
        if (index == 0) {
            //删除头节点特殊处理
            head = head.next;
            return head;
        }
        int i = 0;
        ListNode q = head;
        ListNode pre = q;
        while (i < index && q.next != null) {
            pre = q;
            q = q.next;
            i++;
        }
        //删除q
        pre.next = q.next;
        return head;
    }


    /**
     * 优化一下，头结点加一个哨兵。避免删除头结点时特殊处理
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int size = 0;
        ListNode slaver = new ListNode(0);
        slaver.next = head;
        ListNode p = slaver;
        while (p != null) {
            size++;
            p = p.next;
        }
        int index = size - n;
        int i = 0;
        ListNode q = slaver;
        ListNode pre = q;
        while (i < index && q.next != null) {
            pre = q;
            q = q.next;
            i++;
        }
        //删除q
        pre.next = q.next;
        return slaver.next;
    }
}
