package com.yunhui.base.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2020/6/11 2:11 下午
 * @Author : dushaoyun
 * 为什么用双向链表？
 * <p>
 * 新增元素 是将元素添加到 head->next
 * 删除元素 是移除 tail->pre
 * <p>
 * 如果使用单向链表？ 怎么去找尾节点？从头遍历过去?
 * <p>
 * 可以使用队列吗？不行，队列是FIFO，删除元素太复杂。
 * <p>
 * 使用链表删除元素的时间复杂度很低o(1)
 */
public class LRUCache {
    private Map<String, DLinkedNode>
            cache = new HashMap<>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(String key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            //should raise exception here.
            return -1;
        }
        // move the accessed node to the head;
        this.moveToHead(node);
        return node.value;
    }


    public void set(String key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++count;
            if (count > capacity) {
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * pop the current tail.
     *
     * @return
     */
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
}
