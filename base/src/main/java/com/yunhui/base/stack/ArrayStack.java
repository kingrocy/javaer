package com.yunhui.base.stack;


/**
 * @Date : 2020/7/3 10:46 上午
 * @Author : dushaoyun
 */
public class ArrayStack<T> {

    private T[] table;

    private int size;

    public ArrayStack(int capticy) {
        table = (T[]) new Object[capticy];
        size = 0;
    }

    public void push(T item) {
        if (size >= table.length) {
            throw new RuntimeException("stack size exceed the capticy... ");
        }
        table[size++] = item;
    }

    public T pop() {
        if (size <= 0) {
            throw new RuntimeException("stack is empty ");
        }
        //从数组尾部取数据
        return table[--size];
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
