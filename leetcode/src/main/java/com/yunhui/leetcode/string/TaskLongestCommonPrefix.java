package com.yunhui.leetcode.string;

/**
 * @Date : 2019-09-20 13:55
 * @Desc : https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class TaskLongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        if(strs==null||strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        String temp;
        String result=strs[0];
        int length=result.length();

        for (int i = 1; i <strs.length ; i++) {
            temp=strs[i];
            while (!temp.startsWith(result)){
                if(length==1){
                    return "";
                }
                length--;
                result=result.substring(0, length);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ca","a"}));
    }
}
