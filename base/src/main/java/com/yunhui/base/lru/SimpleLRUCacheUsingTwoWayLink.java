package com.yunhui.base.lru;

/**
 * @Date : 2020/6/30 10:05 上午
 * @Author : dushaoyun
 * @desc lrucache 使用双向链表
 */
public class SimpleLRUCacheUsingTwoWayLink<T> {

    private LinkNode<T> head;
    private LinkNode<T> tail;
    private int n;
    private int maxSize;


    public static void main(String[] args) {
        SimpleLRUCacheUsingTwoWayLink<Integer> link = new SimpleLRUCacheUsingTwoWayLink(5);
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        link.add(5);

        System.out.println(link);

        LinkNode node = link.get(1);
        System.out.println(node);

        link.add(6);
        System.out.println(link);


    }

    public SimpleLRUCacheUsingTwoWayLink(int maxSize) {
        this.maxSize = maxSize;
    }


    public void add(T item) {
        LinkNode<T> node = new LinkNode();
        node.item = item;
        if (head == null && tail == null) {
            //第一个节点
            head = node;
            tail = node;
        } else {
            if (n >= maxSize) {
                removeOldest();
            }
            //头插法
            node.next = head;
            head.pre = node;
            head = node;
        }
        n++;
    }

    public LinkNode get(T item) {
        LinkNode p = head;
        while (p != null) {
            if (p.item.equals(item)) {
                //如果当前节点是尾节点 需要更新一下尾结点
                if (p == tail) {
                    tail = p.pre;
                }
                //删除当前节点
                p.pre.next = p.next;
                //移到头结点
                p.next = head;
                head.pre = p;
                head = p;
                return head;
            } else {
                p = p.next;
            }
        }
        return null;
    }

    public LinkNode removeOldest() {
        LinkNode node = tail;
        tail.pre.next = tail.next;
        tail = tail.pre;
        n--;
        return node;
    }

    @Override
    public String toString() {
        return head.toString();
    }
}

class LinkNode<T> {
    T item;
    LinkNode pre;
    LinkNode next;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(item.toString());
        LinkNode p = next;
        while (p != null) {
            sb.append("->");
            sb.append(p.item.toString());
            p = p.next;
        }
        return sb.toString();
    }
}
