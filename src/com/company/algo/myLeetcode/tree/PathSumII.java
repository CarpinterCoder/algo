package com.company.algo.myLeetcode.tree;

import java.util.ArrayList;

/**
 * @Description: ***
 * @Author:XiaoNing
 * @Date:Greated in 22:20 2018/7/18
 */
/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
 * For example: Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4 8
 * / / \
 * 11 13 4
 * / \ / \
 * 7 2 5 1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *
 * */
public class PathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        record(root,sum,list,lists);
        return lists;
    }

    private void record(TreeNode root, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> lists) {
        if (root==null) return;
        list.add(root.val);
        if(root.left==null && root.right==null){
            if (root.val==sum)
                lists.add(list);
            return;
        }
        if (root.left!=null)record(root.left,sum-root.val,(ArrayList<Integer>)list.clone(),lists);
        if (root.right!=null)record(root.right,sum-root.val,(ArrayList<Integer>)list.clone(),lists);
    }
}
