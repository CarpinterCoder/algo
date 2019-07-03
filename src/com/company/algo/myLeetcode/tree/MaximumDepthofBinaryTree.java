package com.company.algo.myLeetcode.tree;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 21:45 2018/7/18
 */
/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 *
 * */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root==null)return 0;
        int depLeft = maxDepth(root.left);
        int depRight = maxDepth(root.right);
        return 1+(depLeft>=depRight?depLeft:depRight);
    }
}
