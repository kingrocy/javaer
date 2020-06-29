package com.yunhui.base.linklist;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Date : 2020/6/28 5:13 下午
 * @Author : dushaoyun
 */
@NoArgsConstructor
@AllArgsConstructor
public class Node {

    Integer item;
    Node next;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(item);
        Node next = this.next;
        while (next != null) {
            sb.append("->");
            sb.append(next.item);
            next = next.next;
        }
        return sb.toString();
    }
}
