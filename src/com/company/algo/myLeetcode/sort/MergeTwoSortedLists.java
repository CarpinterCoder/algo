package com.company.algo.myLeetcode.sort;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 17:09 2018/7/19
 */
/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 *
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1==null && l2==null)
            return null;

        if (l1==null)
            return l2;

        if (l2==null)
            return l1;

        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode pre = dummy;
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                l1 = l1.next;
                pre = pre.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
                pre.next.next = l1;
                pre = pre.next;
            }
        }

        if (l2!=null){
            pre.next = l2;
        }

        return dummy.next;

    }
}
