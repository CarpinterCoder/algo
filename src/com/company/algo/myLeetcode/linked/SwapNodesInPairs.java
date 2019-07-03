package com.company.algo.myLeetcode.linked;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 11:48 2018/8/1
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null)return head;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur!=null && next!=null){
            int temp = cur.val;
            cur.val = next.val;
            next.val = temp;
            cur = next.next;
            if (cur!=null)
                next = cur.next;
        }
        return head;
    }
}
