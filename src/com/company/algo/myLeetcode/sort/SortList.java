package com.company.algo.myLeetcode.sort;

/**
 * @Description: ***
 * @Author:XiaoNing
 * @Date:Greated in 10:43 2018/7/24
 */
/**
 * 题目：Sort a linked list in O(nlogn) time using constant space complexity.
 *
 * 思路：自底向上归并排序法
 *
 * */
public class SortList {
    public ListNode sortList(ListNode head) {
        // write your code here
        if (head==null || head.next==null)
            return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode p = head;
        int len = 0;
        while (p!=null){
            len++;
            p = p.next;
        }
        for (int sz=1;sz<len;sz*=2){
            ListNode pre = dummy,cur = head;
            while (pre!=null){
                cur = pre.next;
                ListNode l1 = cur,l2 = cur;
                for (int i=1;i<=sz && l2!=null;i++){
                    l2 = l2.next;
                }
                pre.next = merge(l1,l2,sz);
                for (int i=1;i<=2*sz && pre!=null;i++){
                    pre = pre.next;
                }
            }
        }

        return dummy.next;
    }

    private ListNode merge(ListNode l1, ListNode l2, int sz) {
        if (l2==null)
            return l1;

        ListNode p = l1;
        while (p.next!=l2) {
            p = p.next;
        }
        p.next = null;
        p = l2;
        for (int i=1;i<=sz && p!=null;i++){
            p = p.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = l2;
        ListNode pre = dummy;

        while (l1!=null && l2!=p){
            if (l2.val<=l1.val){
                l2 = l2.next;
                pre = pre.next;
            }else {
                pre.next = l1;
                l1 = l1.next;
                pre.next.next = l2;
                pre = pre.next;
            }
        }
        if (l1!=null){
            pre.next = l1;
            while (l1.next!=null){
                l1 = l1.next;
            }
            l1.next = p;
        }

        return dummy.next;
    }

}
