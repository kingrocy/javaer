package com.yunhui.leetcode.array;

/**
 * @Date : 2020/4/9 2:28 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/plus-one/
 */
public class TaskPlusOne {

    public static int[] plusOne(int[] digits) {
        int lastValue=digits[digits.length-1];
        if(lastValue>=9){
            //扩展
            digits[digits.length-1]=0;
            int index=digits.length-2;
            while (index>=0){
                lastValue=digits[index];
                if(lastValue>=9){
                    digits[index]=0;
                    index--;
                }else{
                    digits[index]=lastValue+1;
                    return digits;
                }
            }
            //溢出了
            int [] tmp=new int[digits.length+1];
            tmp[0]=1;
            for (int i = 0; i < digits.length; i++) {
                tmp[i+1]=digits[i];
            }
            digits=tmp;
        }else{
            digits[digits.length-1]=lastValue+1;
        }
        return digits;
    }

    public static void main(String[] args) {
        plusOne(new int[]{8,9,9,9});
    }
}
