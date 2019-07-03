package com.company.algo.myLeetcode.sort;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 20:18 2018/7/19
 */

/**
 * Sort a linked list using insertion sort.
 *
 */
public class InsertionSortList2 {
    public ListNode insertionSortList(ListNode head) {
        if (head==null)return null;
        ListNode pre = head;
        ListNode cur = head.next;
        LinkedList<ListNode> queue = new LinkedList<ListNode>();
        Stack<ListNode> stack = new Stack<ListNode>();
        queue.addFirst(head);
        while (cur!=null){
            while (!queue.isEmpty() && queue.peekFirst().val>cur.val){
                stack.push(queue.pollFirst());
            }
            queue.addFirst(cur);
            cur = cur.next;
            while (!stack.isEmpty()){
                queue.addFirst(stack.pop());
            }
        }
        head = queue.pollLast();
        cur = head;
        while (!queue.isEmpty()){
            cur.next = queue.pollLast();
            cur = cur.next;
        }
        return head;
    }
}
