package com.company.algo.myLeetcode.linked;

/**
 * @Description: ***
 * @Author:XiaoNing
 * @Date:Greated in 8:06 2018/8/1
 */
/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example: Given 1->2->3->4->5->nullptr, m = 2 and n = 4,
 * return 1->4->3->2->5->nullptr.
 * Note: Given m, n satisfy the following condition: 1  m  n  length of list.
 * */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null || m==n)return head;

        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode prevM = dummy, prev = null, cur = null;
        for (int i=1;i<=n;i++){
            if (i<m){
                prevM = prevM.next;
            }else if (i==m){
                prev = prevM.next;
                cur = prev.next;
            }else {
                prev.next = cur.next;
                cur.next = prevM.next;
                prevM.next = cur;
                cur = prev.next;
            }
        }

        return dummy.next;
    }
}
