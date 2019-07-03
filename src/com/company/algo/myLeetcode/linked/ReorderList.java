package com.company.algo.myLeetcode.linked;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 16:40 2018/8/1
 */
/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 要求：空间复杂度O(1)
 * 思路：
 *      由题意知，后面 (n-1)/2 个结点需要分别插入到前面 (n-1)/2 个结点后。
 *      那么先把链表分为两段，前面 n-(n-1)/2 个结点为被插入链表，和后面 (n-1)/2 个结点为插入链表。
 *      在插入之前，需先把插入链表逆序，即第n个结点->第n-1个结点->...
 *
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head==null || head.next==null || head.next.next==null)return;
        ListNode cur = head;
        int len = 0;
        while (cur!=null){
            len++;
            cur = cur.next;
        }
        cur = head;
        for (int i=1;i<len/2;i++){
            cur = cur.next;
        }
        if (len%2==1)cur = cur.next;
        ListNode h1 = new ListNode(1);
        h1.next = cur.next;
        cur.next=null;
        //反转h1指向的链表(后半部分)
        ListNode pre = h1.next;
        cur = pre.next;
        while (cur!=null){
            pre.next = cur.next;
            cur.next = h1.next;
            h1.next = cur;
            cur = pre.next;
        }
        //合并前半部分和后半部分反转后的链表
        cur = head;
        while (h1.next!=null){
            ListNode next = cur.next;
            cur.next = h1.next;
            h1.next = h1.next.next;
            cur.next.next = next;
            cur = next;
        }

    }
}
