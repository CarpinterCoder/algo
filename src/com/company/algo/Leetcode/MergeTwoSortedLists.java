package com.company.algo.Leetcode;
/* Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode newhead = new ListNode(0);
		ListNode p = newhead;
		while (p1 != null && p2 != null) {
			if (p1.val > p2.val) {
				p.next = p2;
				p2 = p2.next;
			} else {
				p.next = p1;
				p1 = p1.next;
			}
			p = p.next;
		}
		if (p1 == null)
			p.next = p2;
		else
			p.next = p1;
		return newhead.next;
	}
}
