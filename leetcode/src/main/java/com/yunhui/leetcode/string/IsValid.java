package com.yunhui.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Date : 2021/2/12 11:49 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/valid-parentheses/
 */
public class IsValid {


    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> characterMap = new HashMap<>();
        characterMap.put(')', '(');
        characterMap.put('}', '{');
        characterMap.put(']', '[');
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (characterMap.containsKey(aChar)) {
                Character character = characterMap.get(aChar);
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character peek = stack.peek();
                    if (!character.equals(peek)) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            } else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }
}
