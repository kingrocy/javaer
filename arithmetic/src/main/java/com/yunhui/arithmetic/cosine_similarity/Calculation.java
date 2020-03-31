package com.yunhui.arithmetic.cosine_similarity;

import lombok.Data;

/**
 * @Date : 2019-06-19 17:00
 * @Author :
 * @CopyRight :
 * @Desc :
 */
@Data
public class Calculation {

    private  double elementA;
    private  double elementB;
    private  double numerator;

    public double result(){
        return numerator / Math.sqrt(elementA * elementB);
    }
}
