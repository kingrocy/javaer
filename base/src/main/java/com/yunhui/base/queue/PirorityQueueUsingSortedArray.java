package com.yunhui.base.queue;

/**
 * @Date : 2020/6/24 4:00 下午
 * @Author : dushaoyun
 */
public class PirorityQueueUsingSortedArray<Key extends Comparable<Key>> {

    private Key[] pq;
    private int n;

    public PirorityQueueUsingSortedArray(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        n = 0;
    }

    public Key delMax() {
        return pq[--n];
    }

    public void insert(Key key) {
        //插入排序
        if (n >= pq.length) {
            throw new RuntimeException("queue is full");
        }
        int i = 0;
        for (; i < n; i++) {
            if (key.compareTo(pq[i]) <= 0) {
                //i后面的元素都需要把位置往后移动一下
                for (int j = n - 1; j >= i; j--) {
                    pq[j + 1] = pq[j];
                }
                break;
            }
        }
        pq[i] = key;
        n++;
    }

    public void insert2(Key key) {
        //插入排序
        if (n >= pq.length) {
            throw new RuntimeException("queue is full");
        }
        int i = n - 1;
        //更简单的实现
        while (i >= 0 && pq[i].compareTo(key) > 0) {
            pq[i + 1] = pq[i];
            i--;
        }
        pq[i + 1] = key;
        n++;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public static void main(String[] args) {

        PirorityQueueUsingSortedArray queue = new PirorityQueueUsingSortedArray(10);

        queue.insert(new People("dusy", 20));
        queue.insert(new People("whh", 18));
        queue.insert(new People("xiaoming", 16));
        queue.insert(new People("xiaowang", 4));
        queue.insert(new People("xiaodu", 4));

        while (!queue.isEmpty()) {
            System.out.println(queue.size());
            System.out.println(queue.delMax());
        }
    }
}
