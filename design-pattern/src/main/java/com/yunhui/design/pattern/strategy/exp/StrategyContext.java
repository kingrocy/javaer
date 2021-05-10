package com.yunhui.design.pattern.strategy.exp;

import lombok.AllArgsConstructor;

/**
 * @author 
 * Created on 2021-05-11
 */
@AllArgsConstructor
public class StrategyContext {

    private Strategy strategy;


    void executeStrategy() {
        strategy.doOperation();
    }


    public static void main(String[] args) {
        StrategyContext strategyContext = new StrategyContext(new SimpleStrategyImpl());
        strategyContext.executeStrategy();
    }

}
