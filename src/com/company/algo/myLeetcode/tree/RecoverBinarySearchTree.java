package com.company.algo.myLeetcode.tree;

import java.util.Stack;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 10:30 2018/7/12
 */

/**
 * 二叉排序树（二叉搜索树）中有两个元素的位置顺序颠倒了，请恢复这个二叉树（不改变二叉树原有的结构）
 * 空间限制：O(1)
 * 非递归法：中序遍历二叉树，同时采用pred、curr、next三个指针指向当前所遍历到的元素（next）以及
 * 前面两个元素（curr、pred）；分三种情况：
 *        1、当处于中间节点时，若(pred.val-curr.val)*(curr.val-next.val)<0，则curr为
 *           所要其中一个顺序颠倒的节点；
 *        2、当处于起始节点时，pred=null，若curr.val>next.val，则curr为所要其中一个
 *           顺序颠倒的节点；
 *        3、当处于末尾节点时，，若curr.val>next.val,则next为所要其中一个顺序颠倒的节点
 * */
public class RecoverBinarySearchTree {
    public static void recoverTree(TreeNode root) {
        if(root==null) return;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pred = null;
        TreeNode curr = null;
        TreeNode next = null;
        TreeNode node1 = null;
        TreeNode node2 = null;
        while (node!=null || !stack.isEmpty()){
            if (node!=null){
                stack.push(node);
                node = node.left;
            }else {
                pred = curr;
                curr = next;
                next = stack.peek();
                if (curr!=null){
                    if (pred==null){
                        if(curr.val>next.val)
                            node1=curr;
                    }else if ((pred.val-curr.val)*(curr.val-next.val)<0){
                        if (node1==null)
                            node1=curr;
                        else
                            node2 = curr;
                    }
                }
                node = stack.pop().right;
            }
        }
        if (curr.val>next.val)node2 = next;
        int temp = node2.val;
        node2.val = node1.val;
        node1.val = temp;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        recoverTree(root);
    }
}
