package com.company.algo.myLeetcode.linked;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 8:31 2018/8/1
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head==null)return null;
        ListNode dummy = new ListNode(x-1);
        dummy.next = head;
        ListNode prev = null;
        ListNode prevX = dummy;
        ListNode cur = null;

        while (prevX.next!=null){
            if (prevX.next.val>=x)
                break;
            prevX = prevX.next;
        }
        if (prevX.next!=null){
            prev = prevX.next;
            cur = prev.next;
        }
        while (cur!=null){
            if (cur.val<x){
                prev.next = cur.next;
                cur.next = prevX.next;
                prevX.next = cur;
                prevX = prevX.next;
                cur = prev.next;
            }else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
