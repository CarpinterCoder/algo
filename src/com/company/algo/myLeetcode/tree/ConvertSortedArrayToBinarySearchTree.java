package com.company.algo.myLeetcode.tree;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 16:34 2018/7/18
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null || nums.length==0) return null;
        if (nums.length==1)return new TreeNode(nums[0]);
        TreeNode root = sortedArrayToBST(nums,0,nums.length-1);
        return root;
    }

    private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if (hi<lo)return null;
        if (hi==lo)return new TreeNode(nums[hi]);
        int mid = hi-(hi-lo)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,lo,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,hi);
        return root;
    }
}
