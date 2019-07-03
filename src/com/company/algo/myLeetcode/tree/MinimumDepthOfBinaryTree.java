package com.company.algo.myLeetcode.tree;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 20:04 2018/7/18
 */
/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest
 * leaf node.
 *
 * */
public class MinimumDepthOfBinaryTree {
    public int run(TreeNode root) {
        if (root==null)return 0;
        if (root.left==null && root.right==null) return 1;
        int depLeft = run(root.left);
        int depRight = run(root.right);
        if (root.left==null)return 1+depRight;
        if (root.right==null)return 1+depLeft;
        return 1+(depLeft<=depRight?depLeft:depRight);
    }
}
