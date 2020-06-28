package com.yunhui.base.queue;

/**
 * @Date : 2020/6/28 9:24 上午
 * @Author : dushaoyun
 */
public class PriorityQueueUsingSortedLink<Key extends Comparable> {

    private Node<Key> head;

    private int n;

    public PriorityQueueUsingSortedLink() {
        head = new Node<>();
    }

    /**
     * 插入时排序
     * 尾插法 + 链表排序为从大到小
     *
     * @param item
     */
    public void insert(Key item) {
        Node<Key> p = head;
        Node<Key> q = new Node();
        q.item = item;
        if (p.next == null) {
            head.next = q;
        } else {
            //todo 感觉链表循环条件都需要这样写
            while (p.next != null) {
                Key nextItem = (Key) p.next.item;
                if (nextItem.compareTo(item) < 0) {
                    break;
                }
                p = p.next;
            }
            q.next = p.next;
            p.next = q;
        }
        n++;
    }


    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Key deleteMax() {
        Node max = head.next;
        if (max == null) {
            return null;
        }
        //删除max
        head.next = max.next;
        n--;
        return (Key) max.item;
    }

    public static void main(String[] args) {

        PriorityQueueUsingSortedLink queue = new PriorityQueueUsingSortedLink();

        queue.insert(new People("xiaoming", 16));
        queue.insert(new People("xiaowang", 4));
        queue.insert(new People("dusy", 20));
        queue.insert(new People("whh", 18));
        queue.insert(new People("xiaodu", 4));

        while (!queue.isEmpty()) {
            System.out.println(queue.size());
            System.out.println(queue.deleteMax());
        }
    }


}
