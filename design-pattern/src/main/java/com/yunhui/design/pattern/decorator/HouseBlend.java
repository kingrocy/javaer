package com.yunhui.design.pattern.decorator;

/**
 * @author 
 * Created on 2021-05-12
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "随便咖啡";
    }


    @Override
    public double cost() {
        return 0.89;
    }
}
