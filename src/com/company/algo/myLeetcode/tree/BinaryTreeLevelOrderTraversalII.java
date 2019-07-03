package com.company.algo.myLeetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 19:03 2018/7/11
 */
/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes’ values. (ie, from left to right,
 * level by level from leaf to root).
 * For example: Given binary tree {3,9,20,#,#,15,7},
 * 3
 * / \
 * 9 20
 * / \
 * 15 7
 * return its bottom-up level order traversal as:
 * [
 * [15,7]
 * [9,20],
 * [3],
 * ]
 * */
public class BinaryTreeLevelOrderTraversalII {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (root==null)return lists;
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        ArrayList<Integer> roots = new ArrayList<Integer>(1);
        roots.add(root.val);
        stack.push(roots);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addFirst(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i=0;i<stack.peek().size();i++){
                TreeNode node = queue.pollLast();
                if (node.left!=null){
                    list.add(node.left.val);
                    queue.addFirst(node.left);
                }
                if (node.right!=null){
                    list.add(node.right.val);
                    queue.addFirst(node.right);
                }
            }
            if (list.size()>0)stack.push(list);
        }
        while (!stack.isEmpty()){
            lists.add(stack.pop());
        }
        return lists;
    }
}
