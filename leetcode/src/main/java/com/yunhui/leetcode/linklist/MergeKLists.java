package com.yunhui.leetcode.linklist;

import com.yunhui.leetcode.hot.ListNode;

/**
 * @Date : 2020/6/30 5:42 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKLists {

    public static void main(String[] args) {
        System.out.println(mergeKLists(new ListNode[]{new ListNode(1, new ListNode(4,new ListNode(5))),new ListNode(1, new ListNode(3,new ListNode(4))),
        new ListNode(2, new ListNode(6))}));
    }

    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     *
     * 空间复杂度 o(1)
     *
     * 时间复杂度：  第一次合并后的长度 n  第二次合并后的长度为2n  则第i次合并后的长度为 i*n
     *
     * 那么第i次合并所花费的时间就是 o(n+(i-1)*n)=o(i*n)
     *
     * 那么总的合并次数就是o(1*n+2*n+...+k*n)=o((1+k)*k*n/2)=o(k^2*n)
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length<=0){
            return null;
        }
        ListNode p = lists[0];
        for (int i = 1; i < lists.length; i++) {
            p = merge(p, lists[i]);
        }
        return p;
    }


    /**
     * 合并  targetNode  listNode
     *
     * @param listNode
     * @param targetNode
     * @return
     */
    public static ListNode merge(ListNode listNode, ListNode targetNode) {
        ListNode result = new ListNode(0);
        ListNode res = result;
        ListNode p = listNode;
        ListNode q = targetNode;
        while (p != null && q != null) {
            int m = p.val;
            int n = q.val;
            if (m < n) {
                res.next = p;
                p = p.next;
            } else {
                res.next = q;
                q = q.next;
            }
            res=res.next;
        }
        if (p == null) {
            res.next = q;
        }
        if (q == null) {
            res.next = p;
        }
        return result.next;
    }
}
