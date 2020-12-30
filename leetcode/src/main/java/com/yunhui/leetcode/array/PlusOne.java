package com.yunhui.leetcode.array;

/**
 * @Date : 2020/12/30 10:31 上午
 * @Author : dushaoyun
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int bey = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int j = digits[i] + bey;
            if (j >= 10) {
                digits[i] = j - 10;
                if (i == 0) {
                    int [] res=new int[digits.length+1];
                    res[0]=1;
                    System.arraycopy(digits, 0, res, 1, digits.length);
                    return res;
                } else {
                    bey = 1;
                }
            } else {
                digits[i] = j;
                return digits;
            }
        }
        return digits;
    }
}
