package com.company.algo.myLeetcode.tree;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 14:38 2018/7/12
 */
public class RecoverBinarySearchTree2 {
    public static void recoverTree(TreeNode root) {
//        if (root==null)return;
        TreeNode pred = null;
        TreeNode curr = null;
        TreeNode next = null;
        TreeNode[] nodes = new TreeNode[2];
        traversal(root,pred,curr,next,nodes);
        if (curr.val>next.val) nodes[1] = next;
        int temp = nodes[0].val;
        nodes[0].val = nodes[1].val;
        nodes[1].val = nodes[0].val;
    }

    private static void traversal(TreeNode root, TreeNode pred, TreeNode curr,
                           TreeNode next,TreeNode[] nodes) {
        if (root==null) return;
        traversal(root.left,pred,curr,next,nodes);
        pred = curr;
        curr = next;
        next = root;
        if (curr!=null){
            if (pred==null){
                if (curr.val>next.val)
                    nodes[0] = curr;
            }else if ((pred.val-curr.val)*(curr.val-next.val)<0){
                if (nodes[0]==null)
                    nodes[0] = curr;
                else
                    nodes[1] = curr;
            }
        }
        traversal(root.right,pred,curr,next,nodes);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        recoverTree(root);
    }
}
