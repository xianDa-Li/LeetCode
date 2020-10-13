package com.company.leetcode.general;

/**
 * Author: XianDaLi
 * Date: 2020/10/13 12:22
 * Remark:
 */
public class T24 {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
		ListNode(int x,ListNode next){
			val = x;
			this.next = next;
		}
	}
	// 递归
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode next = head.next;
		head.next = swapPairs(next.next);
		next.next = head;
		return next;
	}
	// 非递归
	public ListNode swapPairs1(ListNode head) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode temp = pre;
		while (temp.next != null && temp.next.next != null){
			ListNode start = temp.next;
			ListNode end = temp.next.next;
			temp.next = end;
			start.next = end.next;
			end.next = start;
			temp = start;
		}
		return pre.next;
	}
}
