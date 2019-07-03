package com.company.algo.myLeetcode.tree;



import java.util.ArrayList;
import java.util.LinkedList;


/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 15:12 2018/7/11
 */

/**
 * Given a binary tree, return the level order traversal of its nodes’ values.
 * (ie, from left to right, level by level).
 *
 */
public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (root==null) return lists;
        ArrayList<Integer> rootList = new ArrayList<Integer>();
        rootList.add(root.val);
        lists.add(rootList);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addFirst(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i=0;i<lists.get(lists.size()-1).size();i++){
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
            if (list.size()>0)lists.add(list);
        }
        return lists;
    }
}
