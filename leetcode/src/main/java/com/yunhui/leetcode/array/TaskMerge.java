package com.yunhui.leetcode.array;

/**
 * @Date : 2020/4/10 10:27 上午
 * @Author : dushaoyun
 */
public class TaskMerge {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p=0;
        int q=0;
        int i=0;
        while (p<m&&q<n){
            if(nums1_copy[p]<=nums2[q]){
                nums1[i]=nums1_copy[p];
                p++;
            }else{
                nums1[i]=nums2[q];
                q++;
            }
            i++;
        }
        if(p<m){
            System.arraycopy(nums1_copy, p,nums1, i,m-p);
        }
        if(q<n){
            System.arraycopy(nums2, q,nums1, i,n-q);
        }
    }

    public static void main(String[] args) {
        merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }
}
