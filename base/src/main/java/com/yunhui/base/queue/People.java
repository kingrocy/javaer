package com.yunhui.base.queue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date : 2020/6/24 3:52 下午
 * @Author : dushaoyun
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class People implements Comparable<People> {

    private String name;
    private Integer age;

    @Override
    public int compareTo(People o) {
        return this.age.compareTo(o.getAge());
    }
}
