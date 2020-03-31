package com.yunhui.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2019-09-12 09:31
 * @Desc :
 */
public class TaskRomanToInt {


    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num=0;

        int first;
        int next;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            first=map.get(c);
            if(i==s.length()-1){
                num+=first;
            }else{
                next=map.get(s.charAt(i+1));
                if(next<=first){
                    num+=first;
                }else{
                    num-=first;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        TaskRomanToInt instance=new TaskRomanToInt();
        System.out.println(instance.romanToInt("IV"));
    }
}
