package com.company.algo.myLeetcode.linked;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 12:06 2018/8/1
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || k<=1)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = head;
        ListNode next = null;
        for (int i=1;i<k && cur!=null;i++){
            cur = cur.next;
        }
        if (cur==null)return head;
        next = cur.next;

        cur = head.next;
        while (cur!=next){
            head.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = head.next;
        }

        head.next = reverseKGroup(next,k);
        return dummy.next;
    }
}
