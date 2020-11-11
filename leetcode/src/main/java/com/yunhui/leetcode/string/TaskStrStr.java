package com.yunhui.leetcode.string;

/**
 * @Date : 2020/3/31 3:18 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/implement-strstr/
 * @desc 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class TaskStrStr {


    public int strStr(String haystack, String needle) {
       int l=haystack.length();
       int n=needle.length();
       for (int i=0;i<l-n+1;i++){
           if(haystack.substring(i, n+i).equals(needle)){
               return i;
           }
       }
       return -1;
    }

}
