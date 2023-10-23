package com.yunhui.design.pattern.strategy2;

/**
 *
 * Created on 2022-06-24
 */
public interface PayStrategy {

    boolean pay(int paymentAmount);

    void collectPaymentDetails();

}
