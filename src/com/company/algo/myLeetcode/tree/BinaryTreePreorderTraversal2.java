package com.company.algo.myLeetcode.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 19:35 2018/7/10
 */
/**
 * 二叉树前序遍历
 * 非递归版
 *
 * */
public class BinaryTreePreorderTraversal2 {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node!=null){
            if (node!=null){
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop().right;
            }
        }
        return list;
    }
}
