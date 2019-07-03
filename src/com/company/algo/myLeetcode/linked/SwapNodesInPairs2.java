package com.company.algo.myLeetcode.linked;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 11:58 2018/8/1
 */
public class SwapNodesInPairs2 {
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur!=null && next!=null){
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            pre = cur;
            cur = cur.next;
            if (cur!=null)
                next = cur.next;
        }

        return dummy.next;
    }
}
