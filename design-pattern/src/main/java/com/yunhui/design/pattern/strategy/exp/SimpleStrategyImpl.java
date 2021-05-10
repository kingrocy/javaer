package com.yunhui.design.pattern.strategy.exp;

/**
 * @author 
 * Created on 2021-05-11
 */
public class SimpleStrategyImpl implements Strategy {
    @Override
    public void doOperation() {
        System.out.println("this is a simple strategy");
    }
}
