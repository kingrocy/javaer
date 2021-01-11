package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/1/11 3:56 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/intersection-of-two-linked-lists/submissions/
 */
public class GetIntersectionNode {

    /**
     * 核心思想 用两个新指针 分别把两个链表都遍历一遍 如果链表有相交点 那么这两个指针一点会有重合
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        //有相交和没有相交都会退出循环
        while (p != q) {
            if (p == null) {
                p = headB;
            } else {
                p = p.next;
            }
            if (q == null) {
                q = headA;
            } else {
                q = q.next;
            }
        }
        return p;
    }
}
