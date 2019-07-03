package com.company.algo.myLeetcode.linked;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 15:56 2018/8/1
 */
/**
 * 设置一个慢指针，一次走一步，一个快指针，一次走2步
 * 假设快慢指针相遇的时候慢指针走了s，圆环部分长度为r，直线部分长度为x，
 * 从圆环入口处到快慢指针相遇的处长度为a，有：
 *               2s = s+nr (n为正整数)
 *               s = nr = x+a (快慢指针相遇的时候慢指针一定还没有绕环一圈)
 *               s = (n-1)r+r = x+a
 *               x = (n-1)r+(r-a)        (1)
 * 从(1)可以看出在快慢指针相遇处设置一个一次走一步的指针，在链表表头设置一个一次走一步的指针，
 * 两个指针同时前进，它们第一次相遇就是环的入口处
 *
 */
public class LinkedListCycleII {
    public static ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null)
            return null;
        ListNode l1 = head,l2 = head;
        while (l2!=null && l2.next!=null){
            l1 = l1.next;
            l2 = l2.next.next;
            if (l1==l2)
                break;
        }
        if (l2==null || l2.next==null)
            return null;
        l1 = head;
        while (l1!=l2){
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(detectCycle(head));
    }
}

