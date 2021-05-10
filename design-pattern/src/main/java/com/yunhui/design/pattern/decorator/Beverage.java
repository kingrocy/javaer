package com.yunhui.design.pattern.decorator;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 
 * Created on 2021-05-12
 */
@Getter
@Setter
public abstract class Beverage {


    String description;

    public String getDescription() {
        return description;
    }


    public abstract double cost();


}
