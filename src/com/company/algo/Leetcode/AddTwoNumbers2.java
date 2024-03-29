package com.company.algo.Leetcode;

/* You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain 
 * a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode newHead = new ListNode(0);
		ListNode p3 = newHead;
		int val;// store sum
		boolean flag = false;// flag if greater than 10
		
		while (p1 != null || p2 != null) {
			// both p1 and p2 have value
			if (p1 != null && p2 != null) {
				if (flag) 
					val = p1.val + p2.val + 1;
				 else 
					val = p1.val + p2.val;
				// if sum >= 10 or sum<10
				if (val >= 10)
					flag = true;
				else
					flag = false;
				p3.next = new ListNode(val % 10);
				p1 = p1.next;
				p2 = p2.next;
				// p1 is null, because p2 is longer
			} else if (p2 != null) {

				if (flag) {
					val = p2.val + 1;
					if (val >= 10)
						flag = true;
					else
						flag = false;
				} else {
					val = p2.val;
					flag = false;
				}

				p3.next = new ListNode(val % 10);
				p2 = p2.next;

				// //p2 is null, because p1 is longer
			} else if (p1 != null) {

				if (flag) {
					val = p1.val + 1;
					if (val >= 10)
						flag = true;
					else
						flag = false;

				} else {
					val = p1.val;
					flag = false;
				}

				p3.next = new ListNode(val % 10);
				p1 = p1.next;
			}
			p3 = p3.next;
		}

		// handle situation that same length final sum >=10
		if (p1 == null && p2 == null && flag) 
			p3.next = new ListNode(1);
		return newHead.next;
	}
}
