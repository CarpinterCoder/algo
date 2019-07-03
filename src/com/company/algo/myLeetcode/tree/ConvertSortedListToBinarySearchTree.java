package com.company.algo.myLeetcode.tree;

import java.util.Stack;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 17:14 2018/7/18
 */
public class ConvertSortedListToBinarySearchTree {
    public static TreeNode sortedListToBST(ListNode head) {
        if (head==null)return null;
        if (head.next==null)return new TreeNode(head.val);
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode curr = head;
        while (curr!=null){
            stack.push(curr);
            curr = curr.next;
        }
        curr = head;
        ListNode right = null;
        TreeNode root = null;
        ListNode pre = new ListNode(head.val-1);
        pre.next = head;
        while (curr!=null && !stack.isEmpty()){
            ListNode stackNode = stack.pop();
            if (curr.val==stackNode.val){
                right = curr.next;
                root = new TreeNode(curr.val);
                pre.next = null;
                break;
            }
            if (curr.next!=null && curr.next.val==stackNode.val){
                right = curr.next;
                root = new TreeNode(curr.val);
                pre.next = null;
                break;
            }
            pre = curr;
            curr=curr.next;
        }
        if (curr!=head)root.left = sortedListToBST(head);
        root.right = sortedListToBST(right);
        return root;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(-10);
        ListNode curr = head;
        int[] arr = new int[]{-3,0,5,9};
        for (int i=1;i<=4;i++){
            curr.next = new ListNode(arr[i-1]);
            curr = curr.next;
        }
        curr = head;
        while (curr!=null){
            System.out.println(curr.val);
            curr = curr.next;
        }
        TreeNode root = sortedListToBST(head);
    }
}
