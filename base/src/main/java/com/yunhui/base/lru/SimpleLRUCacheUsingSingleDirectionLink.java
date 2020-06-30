package com.yunhui.base.lru;

/**
 * @Date : 2020/6/30 9:01 上午
 * @Author : dushaoyun
 * @desc 使用单向链表实现的lrucache
 */
public class SimpleLRUCacheUsingSingleDirectionLink<T> {


    private Node<T> head;
    private Node<T> tail;
    private int n;
    private int maxSize;


    public static void main(String[] args) {
        SimpleLRUCacheUsingSingleDirectionLink<Integer> lru = new SimpleLRUCacheUsingSingleDirectionLink<>(5);

        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);
        lru.add(5);
        System.out.println(lru);

        Node<Integer> node = lru.get(1);
        System.out.println(node);

        lru.add(6);
        System.out.println(lru);
    }

    public SimpleLRUCacheUsingSingleDirectionLink(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(T item) {
        //直接加到表头
        Node<T> node = new Node<>();
        node.item = item;
        if (head == null&&tail == null) {
            head = node;
            tail = node;
        } else {
            //判断是否达到容量限制
            if (n >= maxSize) {
                removeOldest();
            }
            //头插法
            node.next = head;
            head = node;
        }
        n++;
    }

    public Node<T> get(T item) {
        Node p = head;
        if (p.item.equals(item)) {
            return p;
        }
        while (p.next != null) {
            if (p.next.item.equals(item)) {
                Node tmp = p.next;
                //删除旧节点
                p.next = p.next.next;
                //移到头部 移动的时候判断一下是不是尾节点 如果是尾节点 需要重新设置尾结点
                if (tmp == tail) {
                    tail = p;
                }
                tmp.next = head;
                head = tmp;
                return head;
            } else {
                p = p.next;
            }
        }
        return null;
    }

    public void removeOldest() {
        //移除尾节点
        Node p = head;
        while (p != null && p.next != null && p.next != tail) {
            p = p.next;
        }
        p.next = null;
        tail = p;
        n--;
    }

    public int size() {
        return n;
    }


    @Override
    public String toString() {
        return head.toString();
    }
}


class Node<T> {
    T item;
    Node next;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(item.toString());
        Node p = next;
        while (p != null) {
            sb.append("->");
            sb.append(p.item.toString());
            p = p.next;
        }
        return sb.toString();
    }
}
