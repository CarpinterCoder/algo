package com.company.algo.myLeetcode.linked;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 11:29 2018/8/1
 */
/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example, Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * • Given n will always be valid.
 * • Try to do this in one pass.
 *
 * 思路：设两个指针指向head，让其中一个指针先n-1步，接着两个指针同步走，当第一个指针到达链表最后一个节点时，第二个指针就指向倒数第n个元素
 *
 * */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head==null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy,l2 = dummy;
        for (int i=1;i<=n;i++){
            l2 = l2.next;
        }

        while (l2.next!=null){
            l1 = l1.next;
            l2 = l2.next;
        }

        l1.next = l1.next.next;
        return dummy.next;

    }
}
