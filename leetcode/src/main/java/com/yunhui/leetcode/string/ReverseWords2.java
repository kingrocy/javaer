package com.yunhui.leetcode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Date : 2021/2/11 12:17 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @desc 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWords2 {

    /**
     * 简单的方法
     * 先分隔字符串s  将分隔后的字符数组 从尾部开始遍历
     * 如果不是空字符串 那么就加到list中
     * 然后遍历list 根据 空字符串 重新组装成一个新的字符串就好了
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        List<String> list = new ArrayList<>();
        String[] splits = s.split(" ");
        for (int i = splits.length - 1; i >= 0; i--) {
            if (!"".equals(splits[i])) {
                list.add(splits[i]);
            }
        }
        return list.stream().collect(Collectors.joining(" "));
    }
}
