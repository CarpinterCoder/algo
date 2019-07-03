package com.company.algo.myLeetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Description: ***
 * @Author:XiaoNing
 * @Date:Greated in 19:46 2018/7/11
 */
/**
 * Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right,
 * then right to left for the next level and alternate between).
 * For example: Given binary tree 3,9,20,#,#,15,7,
 * 3
 * / \
 * 9 20
 * / \
 * 15 7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (root==null) return lists;
        ArrayList<Integer> roots = new ArrayList<Integer>(1);
        roots.add(root.val);
        lists.add(roots);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addFirst(root);
        int i = 1;
        while (!queue.isEmpty()){
            i++;
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int j=0;j<lists.get(lists.size()-1).size();j++){
                if (i%2==0){
                    TreeNode node = queue.pollFirst();
                    if (node.right!=null){
                        list.add(node.right.val);
                        queue.addLast(node.right);
                    }
                    if (node.left!=null){
                        list.add(node.left.val);
                        queue.addLast(node.left);
                    }
                }else {
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
            }
            if (list.size()>0)lists.add(list);
        }
        return lists;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        ArrayList<ArrayList<Integer>> lists = zigzagLevelOrder(root);
        System.out.println(lists);
    }
}
