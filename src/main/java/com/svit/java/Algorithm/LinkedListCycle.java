package com.svit.java.Algorithm;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

	// Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle1(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				return true;
		}
		return false;
	}
	public boolean hasCycle2(ListNode head) {
		Set<ListNode> check = new HashSet<ListNode>();
		while(head!=null) {
			if(check.contains(head)) {
				return true;
			}else {
				check.add(head);
			}
			head=head.next;
		}
		return false;
	}
}