package com.yunhui.leetcode.easy;

import lombok.val;

/**
 * @Date : 2020/3/19 3:31 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoListsTask {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p = l1;
        ListNode q = l2;
        ListNode result=new ListNode(0);
        ListNode res=result;
        while (p != null && q != null) {
            int a=p.val;
            int b=q.val;
            if(a<=b){
                res.next=new ListNode(a);
                p=p.next;
            }else{
                res.next=new ListNode(b);
                q=q.next;
            }
            res=res.next;
        }
        if(p==null){
            res.next=q;
        }
        if(q==null){
            res.next=p;
        }
        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}