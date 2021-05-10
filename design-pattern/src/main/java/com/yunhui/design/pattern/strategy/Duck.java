package com.yunhui.design.pattern.strategy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author 
 * Created on 2021-05-10
 */
@NoArgsConstructor
@AllArgsConstructor
public abstract class Duck {

    private FlyBehavior flyBehavior;

    private QuackBehavior quackBehavior;


    void quack() {
        quackBehavior.quack();
    }

    void fly() {
        flyBehavior.fly();
    }

    void swim() {
        System.out.println("swiming");
    }

    abstract void display();
}
