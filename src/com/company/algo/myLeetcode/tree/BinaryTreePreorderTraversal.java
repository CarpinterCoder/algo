package com.company.algo.myLeetcode.tree;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 19:07 2018/7/10
 */

import java.util.ArrayList;

/**
 *二叉树前序遍历
 *递归方法
 *
 */
public class BinaryTreePreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        traversal(root,list);
        return list;
    }

    private void traversal(TreeNode root, ArrayList<Integer> list) {
        if (root==null) return;
        list.add(root.val);
        traversal(root.left,list);
        traversal(root.right,list);
    }
}
