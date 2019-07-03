package com.company.algo.myLeetcode.tree;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 22:54 2018/7/12
 */
/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two
 * subtrees of every node never differ by more than 1.
 *
 * */
public class BalancedBinaryTree1 {
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        if (root.left==null && root.right==null)return true;
        if (root.left!=null && root.right!=null)
            return isBalanced(root.left) && isBalanced(root.right) &&
                    Math.abs(height(root.left, 1) - height(root.right, 1))<=1;
        TreeNode node = null;
        if ((node=root.left)!=null && (node.left!=null || node.right!=null))
            return false;
        if ((node=root.right)!=null && (node.left!=null || node.right!=null))
            return false;
        return true;
    }
    private int height(TreeNode root,int h) {
        if (root==null)return 0;
        if (root.left==null && root.right==null) return 1;
        int h1 = height(root.left,1);
        int h2 = height(root.right,1);
        return h+(h1>h2?h1:h2);

    }
}
