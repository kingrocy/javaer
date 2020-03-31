package com.yunhui.leetcode.easy;

import java.util.*;

/**
 * @Date : 2019-09-20 16:08
 * @Desc :
 * @Link : https://leetcode-cn.com/problems/valid-parentheses/
 */
public class TaskIsValid {

    public static boolean isValid(String s) {

        List<Character> ins=new ArrayList(3){{
            add('(');
            add('[');
            add('{');
        }};

        Map<Character,Character> map=new HashMap(3){
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };

        Stack stack=new Stack();
        for (Character c : s.toCharArray()) {
            if(ins.contains(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    if(!stack.contains(map.get(c))){
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }


    public static boolean isValidNew(String s) {
        while(s.contains("{}")||s.contains("[]")||s.contains("()")){
            s = s.replace("{}", "");
            s=s.replace("[]", "");
            s=s.replace("()", "");
        }
        return s.equals("");
    }

    public static void main(String[] args) {
        System.out.println(isValid("({[}])"));
    }
}
