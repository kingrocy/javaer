package com.yunhui.design.pattern.decorator;

/**
 * @author 
 * Created on 2021-05-12
 */
public class Mocha extends CandimentDecorator {

    Beverage beverage;

    @Override
    public double cost() {
        return beverage.cost() + 0.12d;
    }

    @Override
    public String getDescription() {
        return beverage.description + ",mocha";
    }
}
