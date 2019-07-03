package com.company.algo.myLeetcode.tree;

import java.util.ArrayList;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 21:28 2018/7/10
 */
/**
 * 二叉树中序遍历
 * 递归版
 *
 * */
public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        traversal(root,list);
        return list;
    }

    private void traversal(TreeNode root, ArrayList<Integer> list) {
        if (root==null) return;
        traversal(root.left,list);
        list.add(root.val);
        traversal(root.right,list);
    }
}
