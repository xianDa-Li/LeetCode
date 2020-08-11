package com.company.leetcode.offer;

import java.util.List;

public class O25 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode root = head;
		while (l1 !=null && l2 !=null){
			if(l1.val<=l2.val){
				root.next = l1;
				l1 = l1.next;
			}else {
				root.next = l2;
				l2 = l2.next;
			}
			root = root.next;
		}
		if(l1==null){
			root.next = l2;
		}
		if(l2==null){
			root.next = l1;
		}
		return head.next;
	}
}
