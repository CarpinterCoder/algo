package com.company.algo.myLeetcode.tree;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 16:21 2018/7/12
 */
/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root==null)return true;
        return isMirror(root.left,root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p==null && q==null)return true;
        if (p==null || q==null)return false;
        return p.val==q.val && isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }
}
