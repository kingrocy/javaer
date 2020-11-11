package com.yunhui.leetcode.string;

/**
 * @Date : 2020/4/9 2:18 下午
 * @Author : dushaoyun
 */
public class TaskLengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s != null && !s.equals("")) {
            int i = 0;
            char[] chars = s.toCharArray();
            for (int j = chars.length - 1; j >= 0; j--) {
                if (chars[j] == ' ') {
                    if(i!=0){
                        return i;
                    }
                } else {
                    i++;
                }
            }
            return i;
        }
        return 0;
    }

}
