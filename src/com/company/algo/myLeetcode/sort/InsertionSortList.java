package com.company.algo.myLeetcode.sort;

import java.util.Stack;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 19:33 2018/7/19
 */

/**
 * Sort a linked list using insertion sort.
 *
 */
public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        // write your code here
        if (head==null || head.next==null)
            return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode cur = head;
        while (cur!=null && cur.next!=null){
            ListNode pre = dummy;
            boolean flag = true;
            while (pre.next!=cur.next){
                if (pre.next.val>cur.next.val){
                    flag = false;
                    ListNode next = cur.next;
                    cur.next = next.next;
                    next.next = pre.next;
                    pre.next = next;
                    break;
                }
                pre = pre.next;
            }

            if (flag){
                cur = cur.next;
            }

        }

        return dummy.next;

    }
}
