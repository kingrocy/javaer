package com.yunhui.leetcode.tree;

/**
 * @Date : 2020/5/6 9:59 上午
 * @Author : dushaoyun
 * @link  https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @desc 把一个有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {

    int[] nums;

    public TreeNode process(int left, int right){
        if(left>right){
            return null;
        }
        int p=(left+right)/2;
        TreeNode node=new TreeNode(nums[p]);
        node.left=process(left, p-1);
        node.right=process(p+1,right);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return process(0, nums.length - 1);
    }
}
