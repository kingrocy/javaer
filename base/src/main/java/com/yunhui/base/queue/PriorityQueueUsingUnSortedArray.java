package com.yunhui.base.queue;

/**
 * @Date : 2020/6/24 3:05 下午
 * @Author : dushaoyun
 * @desc 优先级队列（使用无序数组）
 */
public class PriorityQueueUsingUnSortedArray<Key extends Comparable<Key>> {

    private Key[] pq;

    private int N;

    public PriorityQueueUsingUnSortedArray(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        N = 0;
    }

    /**
     * 将元素插入数组的末尾
     *
     * @param item
     */
    public void insert(Key item) {
        if (N >= pq.length) {
            throw new RuntimeException("queue is full");
        }
        pq[N++] = item;
    }

    /**
     * 删除（并返回）最大项
     *
     * @return
     */
    public Key delMax() {
        int max = 0;
        //遍历一遍 找到最大值
        for (int i = 1; i < N; i++) {
            if (pq[max].compareTo(pq[i]) < 0) {
                max = i;
            }
        }
        //把最大值和数组最后的一个元素交换位置
        Key temp = pq[N - 1];
        pq[N - 1] = pq[max];
        pq[max] = temp;
        return pq[--N];
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    public Integer size() {
        return N;
    }

    public static void main(String[] args) {
        PriorityQueueUsingUnSortedArray queue = new PriorityQueueUsingUnSortedArray(10);

        queue.insert(new People("dusy", 20));
        queue.insert(new People("whh", 18));
        queue.insert(new People("xiaoming", 16));
        queue.insert(new People("xiaowang", 4));
        queue.insert(new People("xiaodu", 4));

        while (!queue.isEmpty()){
            System.out.println(queue.size());
            System.out.println(queue.delMax());
        }
    }

}
