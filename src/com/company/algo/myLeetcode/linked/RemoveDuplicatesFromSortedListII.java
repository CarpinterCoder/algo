package com.company.algo.myLeetcode.linked;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 9:28 2018/8/1
 */
/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers
 * from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur!=null && next!=null){
            if (cur.val!=next.val){
                prev = cur;
                cur = next;
                next = cur.next;
            }else {
                while (next!=null && cur.val==next.val){
                    next = next.next;
                }
                prev.next = next;
                cur = next;
                if (cur!=null)next = cur.next;
            }
        }
        return dummy.next;
    }
}
