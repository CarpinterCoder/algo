package com.company.algo.myLeetcode.linked;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 10:47 2018/8/1
 */
/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example: Given 1->2->3->4->5->nullptr and k = 2, return 4->5->1->2->3->nullptr.
 * */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head==null || head.next==null || n==0)return head;

        ListNode p1 = head;
        ListNode p2 = head;

        //遍历求链表长度
        int k=0;
        while (p1!=null){
            k++;
            p1 = p1.next;
        }

        n%=k;
        if (n==0)return head;

        p1 = head;
        for (int i=1;i<=n && p2!=null;i++){
            p2 = p2.next;
        }


        while (p2.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode h1 = p1.next;
        p1.next = null;
        p2.next = head;
        head = h1;
        return head;
    }
}
