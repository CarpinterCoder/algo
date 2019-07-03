package com.company.algo.myLeetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 16:56 2018/7/11
 */
public class BinaryTreeLevelOrderTraversal2 {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (root==null)return lists;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        lists.add(list);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        addList(lists, queue);
        return lists;
    }

    private void addList(ArrayList<ArrayList<Integer>> lists,LinkedList<TreeNode> queue) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<lists.get(lists.size()-1).size();i++){
            TreeNode node = queue.poll();
            if (node.left!=null){
                list.add(node.left.val);
                queue.addLast(node.left);
            }
            if (node.right!=null){
                list.add(node.right.val);
                queue.addLast(node.right);
            }
        }
        if (list.size()>0){
            lists.add(list);
            addList(lists,queue);
        }
    }
}
