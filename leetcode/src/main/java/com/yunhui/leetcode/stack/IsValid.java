package com.yunhui.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Date : 2020/12/29 5:36 下午
 * @Author : dushaoyun
 */
public class IsValid {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (char c : s.toCharArray()) {
            Character character = Character.valueOf(c);
            if (map.containsKey(character)) {
                stack.push(map.get(character));
            } else {
                if(!stack.isEmpty()){
                    Character peek = stack.peek();
                    if (peek.equals(character)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

}
