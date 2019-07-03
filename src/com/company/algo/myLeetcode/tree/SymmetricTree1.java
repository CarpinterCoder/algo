package com.company.algo.myLeetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:  ***
 * @Author:XiaoNing
 * @Date:Greated in 17:16 2018/7/12
 */
/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * */
public class SymmetricTree1 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null)return true;
        Queue<TreeNode> lq = new LinkedList<TreeNode>();
        Queue<TreeNode> rq = new LinkedList<TreeNode>();
        lq.offer(root.left);
        rq.offer(root.right);
        while (!lq.isEmpty() && !rq.isEmpty()){
            TreeNode l = lq.poll();
            TreeNode r = rq.poll();
            if (l==null && r==null) continue;
            if (l==null || r==null) return false;
            if (l.val!=r.val)return false;
            lq.offer(l.left);
            rq.offer(r.right);
            lq.offer(l.right);
            rq.offer(r.left);
        }

        return true;
    }
}
