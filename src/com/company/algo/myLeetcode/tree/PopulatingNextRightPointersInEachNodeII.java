package com.company.algo.myLeetcode.tree;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 10:17 2018/7/13
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root==null || (root.left==null && root.right==null))return;
        TreeLinkNode head = null;
        if (root.left!=null){
            head = root.left;
            root.left.next = root.right;
        } else
            head = root.right;
        TreeLinkNode curr = head;

        while (head!=null){
            TreeLinkNode head2 = null;
            TreeLinkNode curr2 = null;
            TreeLinkNode next2 = null;
            while (head2==null){
                if (curr==null)break;
                if (curr.left!=null){
                    head2 = curr.left;
                    curr2 = curr.left;
                    if (curr.right!=null){
                        head2.next = curr.right;
                        curr2 = curr.right;
                    }
                }else if (curr.right!=null){
                    head2 = curr.right;
                    curr2 = curr.right;
                }
                curr = curr.next;
            }

            while (curr!=null){
                if (curr.left!=null){
                    next2 = curr.left;
                    curr2.next = next2;
                    curr2 = next2;
                }
                if (curr.right!=null){
                    next2 = curr.right;
                    curr2.next = next2;
                    curr2 = next2;
                }
                curr = curr.next;
            }
            head = head2;
            curr = head;
        }
    }
}
