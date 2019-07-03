package com.company.algo.myLeetcode.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 21:09 2018/7/10
 */
/**
 * 二叉树中序遍历
 * 非递归版
 *
 * */
public class BinaryTreeInorderTraversal2 {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()){
            if (node!=null){
                stack.push(node);
                node = node.left;
            }else {
                list.add(stack.peek().val);
                node = stack.pop().right;
            }
        }
        return list;
    }
}
