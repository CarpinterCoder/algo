package com.company.algo.myLeetcode.tree;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 23:32 2018/7/12
 */
public class PopulatingNextRightPointersInEachNode {
    public static void connect(TreeLinkNode root) {
        if (root==null)return;
        TreeLinkNode head = root;
        TreeLinkNode curr = null;
        while (head!=null){
            curr = head;
            while (curr!=null){
                if (curr.left!=null)
                    curr.left.next = curr.right;
                else
                    break;
                if (curr.next!=null)
                    curr.right.next = curr.next.left;
                curr = curr.next;
            }
            head = head.left;
        }
    }
    public static void main(String[] args){
        connect(new TreeLinkNode(0));
    }
}
