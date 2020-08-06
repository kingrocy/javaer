package com.yunhui.leetcode.string;

/**
 * @Date : 2020/8/3 11:04 上午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class ReverseWords {


    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        reverseWords.reverseWords(" ");
    }

    /**
     * 无空格字符构成一个单词。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            String s1 = split[i];
            if (s1.equals(" ") || s1.equals("")) {
                continue;
            }
            sb.append(s1);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString().endsWith(" ") ? sb.substring(0, sb.length() - 1) : sb.toString();
    }


}
