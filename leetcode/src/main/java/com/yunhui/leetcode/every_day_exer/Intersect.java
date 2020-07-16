package com.yunhui.leetcode.every_day_exer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date : 2020/7/13 5:55 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> dict = new HashMap<>();
        int[] less = nums1.length > nums2.length ? nums2 : nums1;
        int[] more = nums1.length > nums2.length ? nums1 : nums2;
        for (int i : less) {
            if (dict.containsKey(i)) {
                dict.put(i, dict.get(i) + 1);
            } else {
                dict.put(i, 1);
            }
        }
        int[] res = new int[more.length];
        int index = 0;
        for (int i : more) {
            if (dict.containsKey(i) && dict.get(i) > 0) {
                res[index++] = i;
                dict.put(i, dict.get(i) - 1);
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;
        int[] res = new int[nums1.length > nums2.length ? nums1.length : nums2.length];
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res[index++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}
