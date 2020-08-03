package com.yunhui.base.stack;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

/**
 * @Date : 2020/7/17 3:14 下午
 * @Author : dushaoyun
 */
public class Calculator {


    //操作数栈
    private Stack<Integer> operandStack;

    //操作符栈
    private Stack<String> operatorStacK;

    private List<String> less = Lists.newArrayList("+", "-");
    private List<String> more = Lists.newArrayList("*", "/");

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int compute = calculator.compute("1+2+3+4+5*5-5/5+1");
        System.out.println(compute);
    }


    public Calculator() {
        operandStack = new Stack();
        operatorStacK = new Stack();
    }

    public int compute(String input) {
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            String opt = String.valueOf(aChar);
            if (Character.isDigit(aChar)) {
                operandStack.push(Integer.parseInt(opt));
            } else {
                boolean higher = priorityHigher(opt);
                //比操作符栈 栈顶元素优先级高 则直接丢到操作符栈
                if (higher) {
                    operatorStacK.push(opt);
                } else {
                    //计算
                    while (!higher) {
                        //取出操作数栈的两个元素和操作符栈的一个操作符 进行计算
                        Integer pop1 = operandStack.pop();
                        Integer pop2 = operandStack.pop();
                        int res = cal(pop2, pop1, operatorStacK.pop());
                        operandStack.push(res);
                        higher = priorityHigher(opt);
                    }
                    operatorStacK.push(opt);
                }
            }
        }
        //计算最终结果
        Integer pop1 = operandStack.pop();
        Integer pop2 = operandStack.pop();
        return cal(pop2, pop1, operatorStacK.pop());
    }


    /**
     * 和操作符栈的栈顶元素比较优先级 如果高 返回true  反之返回false
     *
     * @param operator
     * @return
     */
    private boolean priorityHigher(String operator) {
        if (operatorStacK.isEmpty()) {
            return true;
        }
        String head = operatorStacK.peek();
        if (less.contains(head) && more.contains(operator)) {
            return true;
        }
        return false;
    }


    private int cal(int a, int b, String operator) {
        if (operator.equals("+")) {
            return a + b;
        } else if (operator.equals("-")) {
            return a - b;
        } else if (operator.equals("*")) {
            return a * b;
        } else if (operator.equals("/")) {
            return a / b;
        }
        return 0;
    }
}
