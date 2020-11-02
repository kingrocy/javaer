package com.yunhui.arithmetic.demo;

/**
 * @Date : 2020/10/24 10:26 上午
 * @Author : dushaoyun
 */
public class ClassB {


    public void b(){
        //这种写法是 内部创建一个classA
        ClassA classA=new ClassA();
        String name = classA.getName();
    }


    public void b(ClassA classA){
        //这种写法是外部传入classA
        String name = classA.getName();
    }
}
