package com.company.algo.myLeetcode.tree;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 14:19 2018/7/19
 */
/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree. For example: Given the below binary tree,
 * 1
 * / \
 * 2 3
 * Return 6.
 * */
public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       int sum = maxSum(root);
        return maxSum;
    }

    private int maxSum(TreeNode root) {
        if (root==null)return 0;
        int sum = root.val;
        int l = maxSum(root.left);
        int r = maxSum(root.right);
        if (l>0)sum+=l;
        if (r>0)sum+=r;
        maxSum = Math.max(maxSum,sum);

        return Math.max(Math.max(l,r)+root.val,root.val);
    }
}
