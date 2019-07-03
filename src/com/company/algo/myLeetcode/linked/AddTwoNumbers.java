package com.company.algo.myLeetcode.linked;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 21:59 2018/7/31
 */
/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)return null;
        if (l1==null)return l2;
        if (l2==null)return l1;
        int carry = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1.next!=null && cur2.next!=null){
            int sum = cur1.val+cur2.val + carry;
            cur1.val = sum%10;
            carry = sum/10;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }


        int sum = cur1.val+cur2.val+carry;
        cur1.val = sum%10;
        carry = sum/10;

        if (cur2.next!=null)
            cur1.next = cur2.next;

        ListNode pre = cur1;
        cur1 = cur1.next;
        while (cur1!=null){
            int sum1 = cur1.val+carry;
            cur1.val = sum1%10;
            carry = sum1/10;
            pre = cur1;
            cur1 = cur1.next;
        }

        if (carry==1)
            pre.next = new ListNode(1);



        return l1;

    }
}
