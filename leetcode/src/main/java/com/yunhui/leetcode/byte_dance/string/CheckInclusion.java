package com.yunhui.leetcode.byte_dance.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2020/9/16 3:40 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/permutation-in-string/
 */
public class CheckInclusion {

    /**
     * 思路：
     * 只要判断s2的某个区间内的各字符出现次数  是否等于  s1中的各字符出现次数  即可
     * <p>
     * 如果相同，那么s1经过排列 那么一定会是s2的子串
     *
     */


    /**
     * 暴力法：对s2 遍历 m*n  (m=s2.length   n=s1.length)
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int[] dict = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            dict[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            int[] dict2 = new int[26];
            for (int j = i; j < i + s1.length(); j++) {
                dict2[s2.charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (dict[j] != dict2[j]) {
                    break;
                }
                if (j == 25) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 滑动窗口 只对s2遍历一次
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion2(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int[] dict = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            dict[s1.charAt(i) - 'a']++;
        }
        int[] dict2 = new int[26];
        int k = 0;
        for (int i = 0; i < s2.length(); i++) {
            dict2[s2.charAt(i) - 'a']++;
            //如果窗口大小小于s1的大小 继续扩大窗口
            if (i < s1.length() - 1) {
                continue;
            } else {
                //当前元素的位置 大于窗口的大小时 需要把窗口最左侧的元素移除
                if (i >= s1.length()) {
                    dict2[s2.charAt(k++) - 'a']--;
                }
                //窗口每次滑动时  需要进行一次判断
                for (int j = 0; j < 26; j++) {
                    if (dict[j] != dict2[j]) {
                        break;
                    }
                    if (j == 25) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 滑动窗口优化版
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion3(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int[] dict = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            dict[s1.charAt(i) - 'a']++;
        }
        int[] dict2 = new int[26];
        //定义窗口的左右边界
        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            //将字符移入窗口
            dict2[s2.charAt(right) - 'a']++;
            right++;

            //判断左侧窗口是否要收缩
            if (right > s1.length()) {
                dict2[s2.charAt(left) - 'a']--;
                left++;
            }

            //窗口内的数据判断
            if (right >= s1.length()) {
                //窗口每次滑动时  需要进行一次判断
                for (int j = 0; j < 26; j++) {
                    if (dict[j] != dict2[j]) {
                        break;
                    }
                    if (j == 25) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * 不使用数组 使用map试试
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion4(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                //往窗口添加数据
                window.put(c, window.getOrDefault(c, 0) + 1);
                //修改窗口内元素匹配 数量
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            //判断是否需要把左侧窗口收缩
            if (right-left>=s1.length()){
                //判断是否找到了合法的子串
                if (valid == need.size()) {
                    return true;
                }
                char remove = s2.charAt(left);
                left++;
                if (need.containsKey(remove)) {
                    //必须先判断这步 然后再remove
                    if (need.get(remove).equals(window.get(remove))) {
                        valid--;
                    }
                    window.put(remove, window.get(remove) - 1);
                }

            }
        }
        return false;
    }

    /**
     * from labuladong
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion5(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= s1.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size()){
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        // 未找到符合条件的子串
        return false;
    }

    public static void main(String[] args) {
//        System.out.println('a' + 0);//97    97+25=122
//        System.out.println('z' + 0);//122
//        System.out.println('A' + 0);//65   65+25=90
//        System.out.println('Z' + 0);//90

        System.out.println(checkInclusion4("ab", "eidbaooo"));
    }
}
