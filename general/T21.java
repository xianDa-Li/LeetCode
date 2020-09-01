package com.company.leetcode.general;

import java.util.List;

/**
 * Author: XianDaLi
 * Date: 2020/9/1 15:48
 * Remark:
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class T21 {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode ans = new ListNode(0);
		ListNode temp = ans;
		while(l1 != null && l2 != null){
			if(l1.val <= l2.val){
				temp.next = l1;
				temp = temp.next;
				l1 = l1.next;
			}else{
				temp.next = l2;
				temp = temp.next;
				l2 = l2.next;
			}
		}
		if(l1 == null) temp.next = l2;
		if(l2 == null) temp.next = l1;
		return ans.next;
	}
}
