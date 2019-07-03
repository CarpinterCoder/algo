package com.company.algo.myLeetcode.tree;

import java.util.Stack;

/**
 * @Description: ***
 * @Author:XiaoNing
 * @Date:Greated in 14:53 2018/7/18
 */
/**
 * 题目：判断是否是有效的二叉查找树
 *
 * 思路：中序遍历，若节点值满足递增则是有效二叉查找树
 *
 * */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root==null )return true;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Integer curr = null;
        while (node!=null || !stack.isEmpty()){
            if (node!=null){
                stack.push(node);
                node = node.left;
            }else {
                TreeNode currNode = stack.pop();
                if (curr==null){
                    curr = new Integer(currNode.val);
                }else {
                    if (currNode.val<=curr)
                        return false;
                    else
                        curr = currNode.val;
                }
                node = currNode.right;
            }
        }
        return true;
    }
}
