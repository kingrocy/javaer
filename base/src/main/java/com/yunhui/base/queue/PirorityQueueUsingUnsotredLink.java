package com.yunhui.base.queue;

/**
 * @Date : 2020/6/24 4:48 下午
 * @Author : dushaoyun
 */
public class PirorityQueueUsingUnsotredLink<Key extends Comparable> {

    private Node<Key> node;

    private int n;

    private Node<Key> current;

    public PirorityQueueUsingUnsotredLink() {
        node = new Node<>();
        n = 0;
        current = node;
    }

    /**
     * 尾插法
     * 还有一种方式：头插法
     * @param item
     */
    public void insert(Key item) {
        Node node = new Node();
        node.item = item;
        current.next = node;
        current = current.next;
        n++;
    }

    /**
     * todo 优化
     * @return
     */
    public Key delMax() {
        //遍历链表
        Node p = node.next;
        Node pre = node;
        if (p == null) {
            return null;
        }
        if (p.next == null) {
            n--;
            pre.next = p.next;
            return (Key) p.item;
        }
        Node max = p;
        while (p.next != null) {
            Key nextItem = (Key) p.next.item;
            Key maxItem = (Key) max.item;
            if (maxItem.compareTo(nextItem) < 0) {
                pre = p;
                max = p.next;
            }
            p = p.next;
        }
        //返回值最大的节点 并且移除
        pre.next = max.next;
        n--;
        return (Key) max.item;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public static void main(String[] args) {

        PirorityQueueUsingUnsotredLink queue = new PirorityQueueUsingUnsotredLink();

        queue.insert(new People("xiaoming", 16));
        queue.insert(new People("xiaowang", 4));
        queue.insert(new People("dusy", 20));
        queue.insert(new People("whh", 18));
        queue.insert(new People("xiaodu", 4));

        while (!queue.isEmpty()) {
            System.out.println(queue.size());
            System.out.println(queue.delMax());
        }
    }

}
