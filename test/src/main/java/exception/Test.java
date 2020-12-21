package exception;

import java.math.BigDecimal;

/**
 * @Date : 2020/11/26 11:28 上午
 * @Author : dushaoyun
 */
public class Test {

    public void test() throws MyException {
        try {

        } catch (Exception e) {
            throw new MyException();
        }
    }


    public static void main(String[] args) {
        BigDecimal amount=BigDecimal.TEN;
        amount.subtract(BigDecimal.ONE);
        System.out.println(amount);
    }
}
