package com.yunhui.leetcode.linklist;

import com.yunhui.leetcode.hot.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Date : 2020/7/1 4:56 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class DetectCycle {

    /**
     * 找到环形链表中环所在的位置
     * 蠢方法：需要一个额外的空间 记录已经出现过得节点
     * <p>
     * 聪明方法：
     * <p>
     * 快慢指针法： 设链表无环部分长度为x，有环部分为y
     * <p>
     * 快指针一次跑两步  慢指针一次跑一步
     * <p>
     * <p>
     * 那么当快慢指针相遇时：  假设慢指针跑了slow  快指针跑了fast  那么
     * <p>
     * fast=2*slow  [快指针比慢指针快一倍的速度]
     * <p>
     * fast=slow+n*y  [快慢指针相遇时，肯定是在环内。此时 快指针 比 慢指针多跑了n个环的距离 即 n*y  ]
     * <p>
     * 那么根据是上面两个式子  可以得出 slow=n*y
     * <p>
     * 我们想要知道环的起始点  必须满足如下公式  x+n*y
     * <p>
     * 所以当快慢指针相遇时，慢指针再走x步就是 环所在的位置、
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == slow) {
            while (head != slow) {
                head = head.next;
                slow = slow.next;
            }
            return head;
        } else {
            return null;
        }
    }


    public ListNode detectCycle(ListNode head) {
        Set<ListNode> sets = new HashSet<>();
        while (head != null) {
            if (sets.contains(head)) {
                return head;
            } else {
                sets.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
