package com.yunhui.leetcode.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2021/2/9 7:41 下午
 * @Author : dushaoyun
 * @desc https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache=new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int i = cache.get(1);
        System.out.println(i);

        cache.put(3, 3);
        int i1 = cache.get(2);
        System.out.println(i1);
    }

    private Map<Integer, ListNode> dict = new HashMap<>();

    private int capacity;

    private int size;

    private ListNode head;

    private ListNode tail;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("illegal arguements,capacity must bigger than 0");
        }
        this.capacity = capacity;
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (dict.containsKey(key)) {
            ListNode node = dict.get(key);
            //将这个key 对应的节点 移动到链表的头部
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    private void moveToHead(ListNode node) {
        //删除后面的关系
        node.pre.next = node.next;
        node.next.pre = node.pre;
        //添加前面的关系
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void deleteOldest() {
        ListNode delNode = tail.pre;
        delNode.pre.next = tail;
        tail.pre = delNode.pre;
        dict.remove(delNode.key);
        size--;
    }

    /**
     * 如果关键字已经存在，则变更其数据值；
     * 如果关键字不存在，则插入该组「关键字-值」。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (dict.containsKey(key)) {
            ListNode node = dict.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            //判断容量是否足够
            if (size == capacity) {
                deleteOldest();
            }
            //add 节点
            ListNode newNode = new ListNode(key, value);
            dict.put(key, newNode);
            newNode.next = head.next;
            head.next.pre = newNode;
            head.next = newNode;
            newNode.pre = head;
            size++;
        }
    }

    public static class ListNode {
        private ListNode pre;
        private ListNode next;
        private int key;
        private int val;

        public ListNode(int key, int val) {
            this.key=key;
            this.val = val;
        }
    }
}
