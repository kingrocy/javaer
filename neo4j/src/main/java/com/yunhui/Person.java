package com.yunhui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date : 2019-07-16 14:49
 * @Author :
 * @CopyRight :
 * @Desc :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private int age;


    public Person(String name){
         this.name=name;
    }
}
