package com.yunhui.leetcode.byte_dance.string;

/**
 * @Date : 2020/9/10 4:44 下午
 * @Author : dushaoyun
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] strings = s.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            String c = strings[i];
            if(c.equals(" ")||c.equals("")){
                continue;
            }else{
                sb.append(c);
                if(i!=0){
                    //最后输出的时候 需要判断最后一个字符是否是空格
                    //因为 这边是不对数组最后的一个元素加空格 假如数组的最后一个元素是空格 那么sb就会多出一个空格
                    sb.append(" ");
                }
            }
        }
        return sb.toString().endsWith(" ") ? sb.substring(0, sb.length() - 1) : sb.toString();
    }
}
