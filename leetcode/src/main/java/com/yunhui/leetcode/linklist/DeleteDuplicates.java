package com.yunhui.leetcode.linklist;

/**
 * @Date : 2021/2/16 10:20 下午
 * @Author : dushaoyun
 * @Link https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @Desc 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        while (p != null && p.next != null) {
            ListNode next = p.next;
            if (p.val == next.val) {
                p.next = next.next;
                //如果相等时 不可移动p指针  比如：1->1->1
            }else{
                p = p.next;
            }
        }
        return head;
    }
}
