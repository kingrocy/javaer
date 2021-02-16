package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/2/13 12:17 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @description: 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
 * <p>
 * 这个链表的倒数第 3 个节点是值为 4 的节点。
 */
public class GetKthFromEnd {


    /**
     * 遍历两次 时间复杂度 还是o（n）
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int cnt = 0;
        ListNode p = head;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        ListNode q = head;
        int i = 0;
        while (i < cnt - k) {
            q = q.next;
            i++;
        }
        return q;
    }

    /**
     * 快慢指针 快指针先走k步 之后慢指针继续走 等快指针走到最后时 慢指针就是在倒数第k个位置
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
