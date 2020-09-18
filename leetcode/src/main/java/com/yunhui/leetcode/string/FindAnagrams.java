package com.yunhui.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date : 2020/9/18 1:49 下午
 * @Author : dushaoyun
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || p == null) {
            return list;
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
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
            if (right - left >= p.length()) {
                //判断是否找到了合法的子串
                if (valid == need.size()) {
                    list.add(left);
                }
                char remove = s.charAt(left);
                left++;
                if (need.containsKey(remove)) {
                    if (need.get(remove).equals(window.get(remove))) {
                        valid--;
                    }
                    window.put(remove, window.get(remove) - 1);
                }

            }
        }
        return list;
    }
}
