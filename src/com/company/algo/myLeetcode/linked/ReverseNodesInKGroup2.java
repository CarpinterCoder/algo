package com.company.algo.myLeetcode.linked;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 14:03 2018/8/1
 */
public class ReverseNodesInKGroup2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || k<=1)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prePre = dummy;
        ListNode pre = head;
        ListNode cur = head;

        while (cur!=null){
            for (int i=1;i<k && cur!=null;i++){
                cur = cur.next;
            }
            if (cur==null) break;
            ListNode next = cur.next;
            cur = pre.next;
            while (cur!=next){
                pre.next = cur.next;
                cur.next = prePre.next;
                prePre.next = cur;
                cur = pre.next;
            }
            prePre = pre;
            pre = cur;
        }

        return dummy.next;
    }
}
