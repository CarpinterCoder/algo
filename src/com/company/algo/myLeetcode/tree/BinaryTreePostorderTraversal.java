package com.company.algo.myLeetcode.tree;

import java.util.ArrayList;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 15:01 2018/7/11
 */
/**
 * 二叉树后序遍历
 * 递归版
 *
 * */
public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        traversal(root,list);
        return list;
    }

    private void traversal(TreeNode root, ArrayList<Integer> list) {
        if (root==null) return;
        traversal(root.left,list);
        traversal(root.right,list);
        list.add(root.val);
    }
}
