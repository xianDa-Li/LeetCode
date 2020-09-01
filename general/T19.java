package com.company.leetcode.general;

/**
 * Author: XianDaLi
 * Date: 2020/9/1 15:26
 * Remark:
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class T19 {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			int val = x;
		}
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode ans = new ListNode(0);
		ans.next = head;
		ListNode f = ans;
		ListNode s = ans;
		while (n!=0){
			f = f.next;
			n--;
		}
		while (f.next!=null){
			f = f.next;
			s = s.next;
		}
		s.next = s.next.next;
		return ans.next;
	}
}
