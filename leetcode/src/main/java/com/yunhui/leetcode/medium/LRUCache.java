package com.yunhui.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2020/7/9 9:32 上午
 * @Author : dushaoyun
 */
public class LRUCache {

    private int size;

    private int capacity;

    private Map<Integer, Node> dict = new HashMap<>();

    private Node head;

    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        //拿到元素
        if (dict.containsKey(key)) {
            Node node = dict.get(key);
            //把元素对应的节点 放到链表的表头
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        //1、先检查key是否已经存在 如果存在 则更新其数据 并放到链表头部
        if (dict.containsKey(key)) {
            Node node = dict.get(key);
            node.value = value;
            addToHead(node);
            return;
        }
        //2、不存在 代表需要新加节点
        //检查容量 如果不够 先移除最老的
        if (size == capacity && capacity > 0) {
            removeOldest();
        }
        //容量够 直接添加 节点用头插法的方式
        Node node = new Node(key, value);
        dict.put(key, node);
        if (head == tail && head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        size++;
    }

    public void addToHead(Node node) {
        //如果链表上只有一个节点 或者 当前节点是头节点 则什么也不做
        if (head == tail||node==head) {
            return;
        }
        //删除原节点
        if (node == tail) {
            tail = node.pre;
            node.pre.next = null;
        }else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        //加到头节点
        node.next = head;
        head.pre = node;
        head = node;
    }

    public void removeOldest() {
        dict.remove(tail.key);
        if (tail == head) {
            head = null;
            tail = null;
        } else {
            tail.pre.next = tail.next;
            tail=tail.pre;
        }
        size--;
    }

    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(5);
//
//        lruCache.put(1, 1);
//        lruCache.put(2, 2);
//        lruCache.put(3, 3);
//        lruCache.put(4, 4);
//        lruCache.put(5, 5);
//
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(2));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));
//        System.out.println(lruCache.get(5));
//
//        lruCache.put(6, 6);
//        lruCache.put(7, 7);
//
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(2));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));
//        System.out.println(lruCache.get(5));
//        System.out.println(lruCache.get(6));
//        System.out.println(lruCache.get(7));

        LRUCache lruCache = new LRUCache(2);

        lruCache.get(2);
        lruCache.put(2, 6);
        lruCache.get(1);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        lruCache.get(1);
        lruCache.get(2);
    }
}


class Node {
    int key;
    int value;
    Node pre;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.value = val;
    }
}
