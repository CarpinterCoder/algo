package com.company.algo.myLeetcode.linked;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 9:15 2018/8/1
 */
/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null)return head;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur!=null){
            if (next==null || cur.val!=next.val){
                cur.next = next;
                cur = next;
            }else {
                next = next.next;
            }
        }

        return head;
    }
}
