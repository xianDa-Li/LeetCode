package com.company.leetcode.general;

/**
 * Author: XianDaLi
 * Date: 2020/8/26 17:01
 * Remark:
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 */
public class T2 {

	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ans = new ListNode(0);
		ListNode root = ans;
		int cur = 0;
		int v1 = 0;
		int v2 = 0;
		int sum = 0;
		while (l1!=null || l2!=null || cur!=0){
			v1 = l1!=null ? l1.val : 0;
			v2 = l2!=null ? l2.val : 0;
			sum = v1+v2+cur;
			cur = sum>=10 ? 1 : 0;
			ListNode temp = new ListNode(sum%10);
			root.next = temp;
			root = temp;
			if(l1 !=null)l1 = l1.next;
			if(l2 !=null)l2 = l2.next;
		}
		return ans.next;
	}
}
