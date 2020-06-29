package com.yunhui.leetcode.array;

/**
 * @Date : 2020/6/29 5:43 下午
 * @Author : dushaoyun
 * @link https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    /**
     * 双指针发
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
